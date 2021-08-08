require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/single_intermediate_layout'
require 'buildr/top_level_generate_dir'
require 'buildr/jacoco'
require 'buildr/gwt'

Buildr::MavenCentral.define_publish_tasks(:profile_name => 'org.realityforge', :username => 'realityforge')

desc 'vecmath: A Java vector math library'
define 'vecmath' do
  project.group = 'org.realityforge.vecmath'
  compile.options.source = '1.8'
  compile.options.target = '1.8'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  pom.add_apache_v2_license
  pom.add_github_project('realityforge/vecmath')
  pom.add_developer('realityforge', 'Peter Donald')

  deps = artifacts(:javax_annotation, :jsinterop_annotations, :grim_annotations)
  pom.include_transitive_dependencies << deps

  compile.with deps

  compile.options[:processor_path] << artifacts(:grim_processor, :javax_json)

  gwt_enhance(project)

  package(:jar)
  package(:sources)
  package(:javadoc)

  test.using :testng
  test.options[:java_args] = %w(-ea)
  test.options[:properties] = { 'vecmath.environment' => 'development' }

  doc.
    using(:javadoc,
          :windowtitle => 'Vecmath API Documentation',
          :linksource => true,
          :timestamp => false,
          :link => %w(https://docs.oracle.com/javase/8/docs/api http://www.gwtproject.org/javadoc/latest/)
    )

  cleanup_javadocs(project, 'vecmath')

  ipr.add_default_testng_configuration(:jvm_args => '-ea -Dvecmath.environment=development')

  ipr.add_testng_configuration('core', :jvm_args => '-ea -Dvecmath.environment=development')

  iml.excluded_directories << project._('tmp')

  ipr.add_component_from_artifact(:idea_codestyle)
  ipr.add_code_insight_settings
  ipr.add_nullable_manager
  ipr.add_javac_settings('-Xlint:all,-processing,-serial -Werror')
end

require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/single_intermediate_layout'
require 'buildr/top_level_generate_dir'
require 'buildr/jacoco'
require 'buildr/gwt'

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

  pom.include_transitive_dependencies << artifact(:javax_annotation)
  pom.include_transitive_dependencies << artifact(:jsinterop_annotations)

  compile.with :javax_annotation,
               :jsinterop_annotations,
               :grim_annotations

  project.processorpath << artifacts(:grim_processor, :javax_json)

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
  ipr.add_component('JavaProjectCodeInsightSettings') do |xml|
    xml.tag!('excluded-names') do
      xml << '<name>com.sun.istack.internal.NotNull</name>'
      xml << '<name>com.sun.istack.internal.Nullable</name>'
      xml << '<name>org.jetbrains.annotations.Nullable</name>'
      xml << '<name>org.jetbrains.annotations.NotNull</name>'
      xml << '<name>org.testng.AssertJUnit</name>'
    end
  end
  ipr.add_component('NullableNotNullManager') do |component|
    component.option :name => 'myDefaultNullable', :value => 'javax.annotation.Nullable'
    component.option :name => 'myDefaultNotNull', :value => 'javax.annotation.Nonnull'
    component.option :name => 'myNullables' do |option|
      option.value do |value|
        value.list :size => '2' do |list|
          list.item :index => '0', :class => 'java.lang.String', :itemvalue => 'org.jetbrains.annotations.Nullable'
          list.item :index => '1', :class => 'java.lang.String', :itemvalue => 'javax.annotation.Nullable'
        end
      end
    end
    component.option :name => 'myNotNulls' do |option|
      option.value do |value|
        value.list :size => '2' do |list|
          list.item :index => '0', :class => 'java.lang.String', :itemvalue => 'org.jetbrains.annotations.NotNull'
          list.item :index => '1', :class => 'java.lang.String', :itemvalue => 'javax.annotation.Nonnull'
        end
      end
    end
  end
end

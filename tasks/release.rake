require 'buildr/release_tool'

Buildr::ReleaseTool.define_release_task do |t|
  t.extract_version_from_changelog
  t.zapwhite
  t.ensure_git_clean
  t.verify_no_todo
  t.cleanup_staging
  t.build
  t.patch_changelog('realityforge/vecmath')
  t.stage('PatchReadme', 'Patch the README to update from previous release') do
    contents = IO.read('README.md')
    contents = contents.
      gsub("<version>#{ENV['PREVIOUS_PRODUCT_VERSION']}</version>", "<version>#{ENV['PRODUCT_VERSION']}</version>").
      gsub("/#{ENV['PREVIOUS_PRODUCT_VERSION']}/", "/#{ENV['PRODUCT_VERSION']}/").
      gsub("-#{ENV['PREVIOUS_PRODUCT_VERSION']}-", "-#{ENV['PRODUCT_VERSION']}-")
    IO.write('README.md', contents)

    sh 'git reset 2>&1 1> /dev/null'
    sh 'git add README.md'
    sh 'git commit -m "Update README.md in preparation for release"'
  end
  t.tag_project
  t.stage_release(:release_to => { :url => 'https://stocksoftware.jfrog.io/stocksoftware/staging', :username => ENV['STAGING_USERNAME'], :password => ENV['STAGING_PASSWORD'] })
  t.maven_central_publish
  t.patch_changelog_post_release
  t.push_changes
  t.github_release('realityforge/vecmath')
end

# Remove footer as it is supplied by our layout instead.
class FooterRemoveMarkdownFilter < Nanoc::Filter
  identifier :footer_remove

  def run(content, params={})
    content.gsub(/^\/[^\r\n]+$/, '')
  end
end

# Enclose jumbotron named anchors with correct bootstrap markup for an jumbotron area.
class JumbotronEmbraceHtmlFilter < Nanoc::Filter
  identifier :jumbotron

  def run(content, params={})
    content=content.sub('<p><a name="jumbotron-start"></a></p>', '<div class="jumbotron">')
    content=content.sub('<p><a name="jumbotron-end"></a></p>', '</div>')
    content
  end
end

# Links are designed to work for github repository files but for the homepage they are named differently and positioned in the same dir. Thus our .md files becomes local html files instead and relative links to sources become absolute. 
class FixLinksHtmlFilter < Nanoc::Filter
  identifier :fixlinks
  def run(content, params={})
    content=content.gsub(/<a\shref="([\w\-\/]*).(m|M)(d|D)">/, '<a href="\\1.html">')
    
    # TODO: Rewrite into more general replacements
    content=content.gsub(/<a\shref=".*valjogen-processor\/README\.(html|md)">/, '<a href="processor-readme.html">')
    content=content.gsub(/<a\shref=".*valjogen-examples\/README\.(html|md)">/, '<a href="examples-readme.html">')
    content=content.gsub(/<a\shref=".*valjogen-integrationtests\/README\.(html|md)">/, '<a href="integrationtests-readme.html">')
    content=content.gsub(/<a\shref=".*valjogen-annotations\/README\.(html|md)">/, '<a href="annotations-readme.html">')
    content=content.gsub(/"GETSTARTED.(html|md)"/, '"getstarted.html"')
    content=content.gsub(/"CONTRIBUTING.(html|md)"/, '"contributing.html"')
    content=content.gsub(/"INDEX.(html|md)"/, '"index.html"')
    content=content.gsub(/"INDEX.(html|md)"/, '"index.html"')
    content=content.gsub(/"LICENSE.(html|md)"/, '"license.html"')
    
    content=content.gsub('<a href="src/main/java/com/fortyoneconcepts/valjogen/examples">', '<a href="http://github.com/41concepts/VALJOGen/tree/master/valjogen-examples/src/main/java/com/fortyoneconcepts/valjogen/examples">')
    content=content.gsub('<a href="valjogen-annotations/src/main/java/com/fortyoneconcepts/valjogen/annotations">', '<a href="http://github.com/41concepts/VALJOGen/tree/master/valjogen-annotations/src/main/java/com/fortyoneconcepts/valjogen/annotations">')
    content
  end
end

# Removes the extra space in front of javadoc comment that needs to be inserted in order to avoid markdown eating comment start. 
class JavadocBugfixHtmlFilter < Nanoc::Filter
  identifier :javadocprefixbugfix

  def run(content, params={})
    content.gsub(/ (<span style="[^\"]*">\/\*\*)/, '\\1')
  end
end

# Inserts links to javadoc for annotations in html 
class InsertJavaDocApiLinksHtmlFilter < Nanoc::Filter
  identifier :insert_javadocapi_links

  def run(content, params={})
    content=content.gsub(/(@VALJOGenerate(\([^\)]+\))?)(?!<\/a>)/, '<a href="apidocs/com/fortyoneconcepts/valjogen/annotations/VALJOGenerate.html" title="See JavaDoc">\\1</a>')
    content=content.gsub(/(@VALJOConfigure(\([^\)]+\))?)(?!<\/a>)/, '<a href="apidocs/com/fortyoneconcepts/valjogen/annotations/VALJOConfigure.html" title="See JavaDoc">\\1</a>')
    content
  end
end

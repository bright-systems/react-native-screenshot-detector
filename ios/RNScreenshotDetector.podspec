require 'json'
package = JSON.parse(File.read('../package.json'))

Pod::Spec.new do |s|
  s.name                = "RNScreenshotDetector"
  s.version             = package["version"]
  s.summary             = package["description"]
  s.homepage            = "https://github.com/bright-systems/react-native-screenshot-detector"
  s.license             = package['license']
  s.authors             = "Blend"
  s.description         = <<-DESC
                            Screenshot detector RN
                          DESC
  s.source              = { :git => "https://github.com/bright-systems/react-native-screenshot-detector.git", :tag => "v#{s.version}" }
  s.platform            = :ios, "9.0"
  s.source_files        = 'RNScreenshotDetector/**/*.{h,m}'
  s.dependency          'React'
end
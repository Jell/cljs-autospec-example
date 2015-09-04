(ns my-project.spec-utils.phantomjs
  (:import [org.openqa.selenium.phantomjs PhantomJSDriver]
           [org.openqa.selenium.remote DesiredCapabilities]))

(defn driver []
  (PhantomJSDriver.
   (doto (DesiredCapabilities.)
     (.setCapability "phantomjs.cli.args"
                     (into-array String ["--ignore-ssl-errors=true"
                                         "--webdriver-loglevel=warn"])))))

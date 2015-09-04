(ns my-project.core-spec
  (:require [clj-webdriver.taxi :as taxi]
            [speclj.core :refer :all]
            [my-project.spec-utils :as utils]))

(describe "the whole thing"
  (before-all (utils/build-cljs!))
  (around-all [specs] (utils/with-server specs))
  (around-all [specs] (utils/with-webdriver specs))

  (describe "index page"
    (it "works"
      (taxi/to "http://localhost:10555/")
      (taxi/take-screenshot :file "./screenshot.png")
      (should-contain "hello!" (taxi/text "h2")))))

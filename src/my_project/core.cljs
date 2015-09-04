(ns ^:figwheel-always my-project.core)

(-> js/document
    (.getElementById "title")
    (.-innerHTML)
    (set! "hello!"))

(defn on-js-reload [])

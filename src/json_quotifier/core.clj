(ns json-quotifier.core
  (:require [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn single-quote-string [double-quote-string]
  (str/escape double-quote-string {\" "'"}))

; api
(defn double-quote-string [single-quote-string]
  (str/escape single-quote-string {\' "\""}))

(comment
  (single-quote-string "\"field1\"")
  (single-quote-string "\"field1\":\"value1\"")
  (single-quote-string "{\"field1\":\"value1\"}")

  (single-quote-string "\"field1\"")
  (double-quote-string "'field1'")




  ;; => "'field1'"
  (println 
    (str "'lala' \"lala\""))



  ;; tests
  ;; simple double-quoter works fine
  ;; single-quoter impossible (needs \", can't interpret raw double quotes)

  (def test-json
    "{
      '$id': 'id_1_test_qa',
      '$pk': 'pk_1_test_qa',
      '$model': 'test_model',
      'field1': [[  ['value1[0][0][0]', 'value1[0][0][1]']  , 'value1[0][1]'], 'value1[1]']
      }")


  (println
    (double-quote-string test-json)))






(comment 
  "double quote the gherkin files of the Digital twin specflow project"
  "creates v2 files at their side with the new double quoted format"

  (def gherkin-file-path "C:\\Users\\l.crapart\\source\\repos\\DigitalGraphData\\tests\\DigitalTwin.tests.IntegrationTests\\Features\\Update\\UpdateEntityPatch_BasicPropertiesWithPartialJson.feature")

  (def gherkin-file (slurp gherkin-file-path))

  (type gherkin-file)
  (println gherkin-file)


  (def double-quote-gherkin-file (double-quote-string gherkin-file))

  (println double-quote-gherkin-file)

  (def output-gherkin-file-path "C:\\Users\\l.crapart\\source\\repos\\DigitalGraphData\\tests\\DigitalTwin.tests.IntegrationTests\\Features\\Update\\UpdateEntityPatch_BasicPropertiesWithPartialJson2.feature")
  
  ;; outputs new file double-quoted
  (spit output-gherkin-file-path double-quote-gherkin-file)


  (def add-feature-path "C:\\Users\\l.crapart\\source\\repos\\DigitalGraphData\\tests\\DigitalTwin.tests.IntegrationTests\\Features\\Update\\UpdateEntityPatch_AddItemArray.feature")
  (def remove-feature-path "C:\\Users\\l.crapart\\source\\repos\\DigitalGraphData\\tests\\DigitalTwin.tests.IntegrationTests\\Features\\Update\\UpdateEntityPatch_RemoveItemArray.feature")
  (def update-feature-path "C:\\Users\\l.crapart\\source\\repos\\DigitalGraphData\\tests\\DigitalTwin.tests.IntegrationTests\\Features\\Update\\UpdateEntityPatch_UpdateArrayItem.feature")
  (def path-feature-path "C:\\Users\\l.crapart\\source\\repos\\DigitalGraphData\\tests\\DigitalTwin.tests.IntegrationTests\\Features\\Update\\UpdateEntityPatch_BasicPropertiesWithPath.feature")


  (defn path-without-end-feature [path]
    ((clojure.string/split path #".feature") 0))

  (path-without-end-feature add-feature-path)

  (def add-feature-path-2 (str (path-without-end-feature add-feature-path) "2.feature"))
  (def remove-feature-path-2 (str (path-without-end-feature remove-feature-path) "2.feature"))
  (def update-feature-path-2 (str (path-without-end-feature update-feature-path) "2.feature"))
  (def path-feature-path-2 (str (path-without-end-feature path-feature-path) "2.feature"))

  add-feature-path-2
  remove-feature-path-2
  update-feature-path-2
  path-feature-path-2


  ;; outputs the new files double-quoted
  (spit add-feature-path-2 
    (double-quote-string (slurp add-feature-path)))

  (spit remove-feature-path-2 
    (double-quote-string (slurp remove-feature-path)))

  (spit update-feature-path-2 
    (double-quote-string (slurp update-feature-path)))

  (spit path-feature-path-2 
    (double-quote-string (slurp path-feature-path))))
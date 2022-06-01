(ns json-quotifier.core
  (:require [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn single-quote-string [double-quote-string]
  (str/escape double-quote-string {\" "'"}))

(defn double-quote-strieng [single-quote-string]
  (str/escape single-quote-string {\' "\""}))

(single-quote-string "\"field1\"")
(single-quote-string "\"field1\":\"value1\"")
(single-quote-string "{\"field1\":\"value1\"}")


(double-quote-string "'field1'")




;; => "'field1'"
(println (str "'lala' \"lala\""))







;; tests
;; simple double-quoter works fine
;; single-quoter impossible (needs \", can't interpret raw double quotes)

(def test-json
  "{
		'$id': 'id_1_test_qa',
		'$pk': 'pk_1_test_qa',
		'$model': 'test_model',
		'field1': {
				'field11' : 'value11',
				'field12': 1,
				'field13': true,
				'field14': ['value14[0]', 'value14[1]'],
				'field15': {'field151' : 'value151', 'field152' : 'value152'},
				'field16': '',
				'field17': null
				}
		}")


(println
  (double-quote-string test-json))

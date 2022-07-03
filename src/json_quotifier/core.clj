(ns json-quotifier.core
  (:require [clojure.string :as str]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn single-quote-string [double-quote-string]
  (str/escape double-quote-string {\" "'"}))

(defn double-quote-string [single-quote-string]
  (str/escape single-quote-string {\' "\""}))

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
  (double-quote-string test-json))




;; idea for clojure developement
;; explore all IDEs 

;; reqs
;; -snappy (like sublime)
;; -inline evaluation (like clojure sublimed)
;; -support cljs repl
;; -clean color highlight (like sublime default colors for clojure/script)
;; -paredit parinfer stuff working fine
;; -all in one (cmd into the IDE, or easy shortcut to open with good path)

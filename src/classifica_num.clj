(ns classifica-num)

(defn classifica-numero
  [num]
  (cond
    (= num 0) "zero"
    (> num 0 ) "positivo"
    :else "negativo"))
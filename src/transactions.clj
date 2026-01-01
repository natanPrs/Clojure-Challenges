(ns transactions)

(def transacoes
  [{:valor 100 :tipo :entrada}
   {:valor 50  :tipo :saida}
   {:valor 200 :tipo :entrada}
   {:valor 30  :tipo :saida}])

(defn saldo
  [transacoes]
  (let [entradas (->> transacoes
                      (filter #(=  (:tipo %) :entrada))
                      (map :valor)
                      (reduce +))
        saidas (->> transacoes
                    (filter #(= (:tipo %) :saida))
                    (map :valor)
                    (reduce +))]
    (- entradas saidas)))
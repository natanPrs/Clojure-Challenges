(ns greet-or-nil)


(defn greet-handler
  [request]
  (let
    [name (or
            (get-in request [:query-params "name"])
            "visitante")]
    {:status 200
     :body {:greeting (str "Ola, " name)}}))
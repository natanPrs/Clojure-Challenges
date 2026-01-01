(ns greet-handler-api)

(defn greet-handler
  [request]
  {:status 200
   :body {:greeting (str "Ola, "
                         (get-in request [:query-params "name"]))}})
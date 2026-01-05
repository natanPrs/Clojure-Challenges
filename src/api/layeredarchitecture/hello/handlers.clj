(ns api.layeredarchitecture.hello.handlers)

(defn hello-handler
  [request]
  (if-let [name (get-in request [:query-params "name"])]
    {:status 200
     :body {:message (str "Ola " name)}}
    {:status 400
     :body {:error "Invalid request: Name is required"}}))
(ns greet-or-nil-plus)

(defn greet-handler
  [request]
  (if (nil? request)
    {:status 400
     :body {:error "Insert a valid value"}}
    {:status 200
     :body {:greeting (str "ola, "
                           (get-in request [:query-params "name"]))}}))
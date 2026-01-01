(ns greet-or-nil-pro)

(defn greet-handler
  [request]
  (let [name (get-in request [:query-params "name"])]
    (if (or (nil? name) (empty? name))
      {:status 400
       :body {:error "Insert a valid value to name"}}
      {:status 200
       :body {:greeting
              (str "Ola " name)}})))

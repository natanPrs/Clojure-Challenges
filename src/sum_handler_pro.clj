(ns sum-handler-pro)

(defn sum-handler
  [request]
  (if-let [a (get-in request [:query-params "a"])]
    (if-let [b (get-in request [:query-params "b"])]
      (if-let [ar (parse-long a)]
        (if-let [br (parse-long b)]
          {:status 200
           :body {:result (+ ar br)}}
          {:status 400
           :body {:error "'b' must be a number!"}})
        {:status 400
         :body {:error "'a' must be a number!"}})
      {:status 400
       :body {:error "value of 'b' is required!"}})
    {:status 400
     :body {:error "value of 'a' is required!"}}))
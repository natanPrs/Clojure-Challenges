(ns sum-handler)

(defn sum-handler
  [request]
  (let [a (get-in request [:query-params "a"])
        b (get-in request [:query-params "b"])]
    (if  (or (nil? a) (empty? a)
             (nil? b) (empty? b))
      {:status 400
       :body {:error "a and b are required!"}}
      (let [ar (parse-long a)
            br (parse-long b)]
        (if (or (= ar nil) (= br nil))
          {:status 400
           :body {:error "a and b must be a number!"}}
          {:status 200
           :body {:result (+ ar br)}}))
      )
    ))

(defn testes
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

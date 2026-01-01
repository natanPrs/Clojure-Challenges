(ns ping-handler-api)

(defn ping-handler
  [_request]
  (let [response {:status 200 :body {:message "API Clojure working!!"}}]
    response))

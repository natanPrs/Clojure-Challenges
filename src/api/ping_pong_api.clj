(ns api.ping-pong-api
  (:require
    [reitit.ring :as ring]
    [ring.adapter.jetty :as jetty]
    [ring.middleware.json :as json]
    [ring.middleware.params :as params]))


(defn ping-handler
  [_request]
  {:status 200
   :body {:message "pong"}})

(defn hello-handler
  [request]
  (if-let [name (get-in request [:query-params "name"])]
    {:status 200
     :body {:message (str "Ola " name)}}
    {:status 400
     :body {:error "Invalid request: Name is required"}}))

(def app
  (-> (ring/ring-handler
        (ring/router
          [["/ping"  {:get ping-handler}]
           ["/hello" {:get hello-handler}]]))
      (params/wrap-params)
      (json/wrap-json-response)))


(defn start-server []
  (jetty/run-jetty app {:port 3000 :join? false}))


(ns api.usersapi.api.server
  (:require
    [reitit.ring :as ring]
    [ring.adapter.jetty :as jetty]
    [ring.middleware.json :as json]
    [ring.middleware.params :as params]
    [api.usersapi.api.routes :as user-routes]))

(def app
  (-> (ring/ring-handler user-routes/app-routes)
      (params/wrap-params)
      (json/wrap-json-response)))

(defn start-server []
  (jetty/run-jetty app {:port 3000 :join false}))


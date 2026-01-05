(ns api.layeredarchitecture.api.server
  (:require
    [reitit.ring :as ring]
    [ring.adapter.jetty :as jetty]
    [ring.middleware.json :as json]
    [ring.middleware.params :as params]
    [api.layeredarchitecture.api.routes :refer [app-routes]]))

(def app
  (-> (ring/ring-handler app-routes)
      (params/wrap-params)
      (json/wrap-json-response)))

(defn start-server []
  (jetty/run-jetty app {:port 3000 :join false}))

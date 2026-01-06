(ns api.userapiplus.server
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.json :as json]
            [api.userapiplus.routes :as routes]))

(def app
  (-> (ring/ring-handler routes/app-routes)
      (json/wrap-json-body {:keywords? true})
      (json/wrap-json-response)))

(defn start-app []
  (jetty/run-jetty app {:port 3000 :join false}))

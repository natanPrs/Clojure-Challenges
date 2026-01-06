(ns api.userapiplus.routes
  (:require [reitit.ring :as ring]
            [api.userapiplus.handler :as handler]))

(def create-user
  ["/create-user" {:post handler/create-user}])

(def find-user-by-id
  ["/user/:id" {:get handler/find-user-by-id}])

(def app-routes
  (ring/router
    [create-user
     find-user-by-id]))
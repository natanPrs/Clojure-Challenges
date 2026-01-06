(ns api.usersapi.api.routes
  (:require
    [reitit.ring :as ring]
    [api.usersapi.handlers.users :as handler]))

(def get-users-route
  ["/users" {:get handler/get-users}])

(def get-user-id-route
  ["/users/:id" {:get handler/get-user-id}])

(def app-routes
  (ring/router
    [get-users-route
     get-user-id-route]))

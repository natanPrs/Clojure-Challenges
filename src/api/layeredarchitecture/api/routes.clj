(ns api.layeredarchitecture.api.routes
  (:require
    [reitit.ring :as ring]
    [api.layeredarchitecture.ping.routes :refer [ping-routes]]
    [api.layeredarchitecture.hello.routes :refer [hello-routes]]))


(def app-routes
  (ring/router
    [ping-routes
     hello-routes]))
(ns api.layeredarchitecture.ping.routes
  (:require [api.layeredarchitecture.ping.handlers :as handlers]))

(def ping-routes
  ["/ping"
   {:get handlers/ping-handler}])
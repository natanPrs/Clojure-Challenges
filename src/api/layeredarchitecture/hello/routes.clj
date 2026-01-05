(ns api.layeredarchitecture.hello.routes
  (:require [api.layeredarchitecture.hello.handlers :as handlers]))

(def hello-routes
  ["/hello"
   {:get handlers/hello-handler}])
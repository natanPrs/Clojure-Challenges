(ns api.layeredarchitecture.api.core
  (:require [api.layeredarchitecture.api.server :as server]))

(defn -main []
  (server/start-server))

(ns api.layeredarchitecture.ping.handlers)

(defn ping-handler
  [_]
  {:status 200
   :body {:message "pong"}})
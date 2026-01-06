(ns api.userapiplus.handler
  (:require [api.userapiplus.domain :as domain]))

(defn create-user
  [{:keys [body]}]
  {:status 200
   :body {:user (domain/create-user body)}})

(defn find-user-by-id
  [request]
  (let [id (get-in request [:path-params :id])]
     {:status 200
      :body (domain/find-user-by-id id)}))

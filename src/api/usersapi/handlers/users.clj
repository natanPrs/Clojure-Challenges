(ns api.usersapi.handlers.users
  (:require [api.usersapi.domain.users :as domain]))

(defn get-users
  [_]
  {:status 200
   :body {:users (domain/get-users nil)}})

(defn get-user-id
  [request]
  (let [id (get-in request [:path-params :id])]
    (if-let [user (domain/get-user-id id)]
      {:status 200
       :body user}
      {:status 404
       :body {:error "User not found"}})))

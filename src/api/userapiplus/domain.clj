(ns api.userapiplus.domain
  (:require [api.userapiplus.repository :as repository])
  (:import (java.util UUID)))

(defn create-user
  [user]
  (let [id (str (UUID/randomUUID))
        user-with-id (assoc user :id id)]
    (repository/save-user! user-with-id)
    user-with-id))

(defn find-user-by-id
  [id]
  (repository/find-user-by-id id))
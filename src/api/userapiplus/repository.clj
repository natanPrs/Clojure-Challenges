(ns api.userapiplus.repository)

(def users (atom []))

(defn save-user!
  [user]
  (swap! users conj user)
  user)

(defn find-user-by-id
  [id]
  (some #(when (= (:id %) id) %) @users))
(ns api.usersapi.domain.users)

(def user-list
  [{:id 1 :name "Natan"}
    {:id 2 :name "Ayumi"}
    {:id 3 :name "Bruna"}])

(defn get-users
  [_]
  user-list)

(defn get-user-id
  [id]
  (when-let [id (some-> id parse-long)]
    (some #(when (= (:id %) id) %) user-list)))

(ns medicina-interna.functions.fade-in
  (:require
    [medicina-interna.functions.util :as futil]))

(defn fade-in-interpolator
  [from to]
  (fn [v] (* v (- to from))))

(defn fade-in
  [atom-to-transition
   & {:keys [duration
             times
             from
             to
             completion-transformer]
      :or {duration 1000
           times 50
           from 0
           to 100}
      :as args}]
  (futil/transition-atom
    atom-to-transition
    (into {:duration duration
           :times times
           :from from
           :to to
           :interpolator fade-in-interpolator}
          args)))

(ns medicina-interna.functions.fly
  (:require
    [medicina-interna.functions.util :as futil]))

(defn fly-interpolator
  [from to]
  (fn [v] (let [{fx :x fy :y} from
                {tx :x ty :y} to
                xdiff (- tx fx)
                ydiff (- ty fy)]
            {:x (- tx (- xdiff (* v xdiff)))
             :y (- ty (- ydiff (* v ydiff)))})))

(defn fly
  [atom-to-transform
   & {:keys [duration
             times
             from
             to
             completion-transformer]
      :or {duration 1000
           times 50}
      :as args}]
  (futil/transition-atom
    atom-to-transform
    (into {:duration duration
           :times times
           :from from
           :to to
           :interpolator fly-interpolator}
          args)))

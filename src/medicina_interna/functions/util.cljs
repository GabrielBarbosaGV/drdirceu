(ns medicina-interna.functions.util)

(defn- now [] (.getTime (js/Date.)))

(defn times-within-duration
  [{:keys [duration times function]} & {callback :callback}]
  (let [looper (js/setInterval
                function
                (/ duration times))]
    (js/setTimeout
      #(do (js/clearInterval looper)
           (when callback (callback)))
      duration)))

(defn completion-since
  [start duration]
  (/ (- (now) start) duration))

(defn transition-atom
  [atom-to-transition
   {:keys [duration times from to interpolator completion-transformer]
    :or {completion-transformer (fn [v] v)}}]
  (let [start (now)
        transitioner (interpolator from to)]
    (times-within-duration
      {:duration duration
      :times times
      :function #(swap! atom-to-transition
                        (fn [v]
                          (let [completion
                                (completion-transformer
                                  (completion-since
                                    start
                                    duration))]
                            (transitioner completion))))})))

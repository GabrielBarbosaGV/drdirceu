(ns medicina-interna.components.header)

(def default-top-div-style
  {:background-color "rgb(19, 74, 167)"
   :width "100%"
   :height "200px"})

(def default-top-div-props
  {:style default-top-div-style})

(defn header
  [& {:keys [top-div-props]
      :or {top-div-props default-top-div-props}
      :as data}]
  [:div top-div-props])

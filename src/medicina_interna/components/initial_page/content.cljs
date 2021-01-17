(ns medicina-interna.components.initial-page.content)

(def default-top-div-props
  {:style
   {:text-align "center"}})

(defn content []
  [:div
   default-top-div-props
   [:h1 "Sobre"]
   [:p "Somos médicos :)"]])

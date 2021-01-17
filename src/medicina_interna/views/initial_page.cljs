(ns medicina-interna.views.initial-page
  (:require
    [medicina-interna.components.header :as header]
    [medicina-interna.components.initial-page.content :as ic]
    [medicina-interna.functions.fade-in :as fade]
    [medicina-interna.functions.fly :as fly]
    [medicina-interna.functions.util :as futil]
    [reagent.core :as r]))

(def root-div-style
  {:style
   {:width "100%"
    :height "100%"}})

(def header-props
  {:style
   {:width "100%"
    :height "70px"
    :background-image "linear-gradient(rgb(19, 74, 167), rgb(10, 50, 100))"}})

(def text-opacity (r/atom 100))
(def text-translate (r/atom {:x 0 :y -100}))

(fly/fly text-translate
         :duration 1000
         :times 300
         :from {:x 0 :y 300}
         :to {:x 0 :y 0}
         :completion-transformer #(js/Math.pow % (/ 1 3)))

(defn initial-page []
  [:div root-div-style
   [header/header :top-div-props header-props]
   [:div
    {:style
     {:width "100%"
      :display "flex"
      :align-items "center"
      :flex-direction "column"
      :color "rgb(42, 52, 81)"
      :opacity (str @text-opacity "%")
      :transform (str
                   "translate("
                   (:x @text-translate)
                   "%,"
                   (:y @text-translate)
                   "%)")}}
    [:div
     {:style
      {:width "82%"
       :display "flex"
       :flex-direction "column"
       :align-items "center"}}
     [ic/content]]]])

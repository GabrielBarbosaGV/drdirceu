(ns ^:figwheel-hooks medicina-interna.main
  (:require
    [reagent.dom :as r.dom]
    [medicina-interna.views.initial-page :as init]))

(defn app [] [init/initial-page])

(defn mount []
  (r.dom/render [app] (js/document.getElementById "root")))

(defn ^:after-load re-render []
  (mount))

(defonce start-up (do (mount) true))

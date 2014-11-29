/**
 * Created by Юлия on 29.11.2014.
 */
window.onload = function () {
    // Создаем карту и станции
    var map,
        stations = [{point: new YMaps.GeoPoint(59.966965, 30.310821), name: "Каменноостровский проспект, 39"},
            {point: new YMaps.GeoPoint(60.005316, 30.300147), name: "Коломяжский проспект, 17"},
            {point: new YMaps.GeoPoint(59.927459, 30.36032), name: "Лиговский проспект, 30а"}];

    // Создание экземпляра карты и его привязка к созданному контейнеру
    var map = new YMaps.Map(YMaps.jQuery("#YMapsID")[0]);

    // Установка для карты ее центра и масштаба
    map.setCenter(new YMaps.GeoPoint(59.92, 30.32), 15);

    // Добавление элементов управления
    var typeControl = new YMaps.TypeControl([YMaps.MapType.MAP, YMaps.MapType.SATELLITE, YMaps.MapType.HYBRID], [0, 1, 2]);
    map.addControl(typeControl)
    map.enableScrollZoom();
    map.addControl(new YMaps.SmallZoom());

    // Добавление оверлеев на карту
    for (var i = 0; i < stations.length; i++) {
        map.addOverlay(createOverlay(stations[i])) // Добавление происходит через функцию createOverlay, которая написана ниже
    }
};

// Функция createOverlay для создания оверлея и ссылки на него
function createOverlay(station) {
    var link = YMaps.jQuery("<a href=\"#\">" + station.name + "</a>"), // Создание ссылки
        newOverlay = new SimpleOverlay(station.point, station.name, link); // Создание оверлея

    // Установка обработчика кликов по ссылке
    link
        .bind("click", function () {
            if (link.hasClass("active")) return;
            newOverlay.openBalloon();
            return false;
        })
        .appendTo(YMaps.jQuery("#links"))

    return newOverlay;
}

// Класс пользовательского оверлея, реализующего класс YMaps.IOverlay
function SimpleOverlay(geoPoint, name, link) {
    var map, _this = this, offset = new YMaps.Point(-10, -29);

    // Вызывается при добавления оверлея на карту
    this.onAddToMap = function (pMap, parentContainer) {
        map = pMap;
        getElement().appendTo(parentContainer);
        this.onMapUpdate();
    };

    // Вызывается при удаление оверлея с карты
    this.onRemoveFromMap = function () {
        if (getElement().parent()) {
            getElement().remove();
        }
    };

    // Вызывается при обновлении карты
    this.onMapUpdate = function () {

        // Смена позиции оверлея
        var position = map.converter.coordinatesToMapPixels(geoPoint).moveBy(offset);
        getElement().css({
            left: position.x,
            top: position.y
        })
    };

    // Метод для открытия балуна
    this.openBalloon = function () {
        // Делаем ссылку, связанную с оверлеем, активной
        link.addClass("active"); // Приписываем этой ссылке class="active"

        // Скрываем оверлей
        getElement().css("display", "none");

        // Открываем балун и по закрытию балуна возвраем в первоначальный вид метки
        map.openBalloon(geoPoint, name, {
            onClose: function () {
                link.removeClass("active");
                getElement().css("display", "");
            }
        });
    };

    // Получить ссылку на DOM-ноду оверлея
    function getElement() {
        var element = YMaps.jQuery("<div class=\"overlay\"/>");

        // Устанавливаем z-index как у метки
        element.css("z-index", YMaps.ZIndex.Overlay);

        // При щелчке на оверлеи открывается балун
        element.bind("click", function () {
            _this.openBalloon();
        });

        // После первого вызова метода, он переопределяется,
        // чтобы дважды не создавать DOM-ноду
        return (getElement = function () {
            return element
        })();
    };
}

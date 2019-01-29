<%-- 
    Document   : CreateFotoForm
    Created on : Oct 24, 2018, 9:36:06 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="createFotoForm">
    <h3>Пожалуйста, прикрепите фото и заполните поля</h3>
    <form id="fotoForm" method="Post" name="fotoForm" enctype="multipart/form-data" action="fileFotoSave">
        <div class="block">
            <span>Происхождение болезни: </span>
            <div class="dropdown">
                <select size="1"  name="origin_illness" value="${origin_illness}">
                    <option name="origin_illness_none">Нет данных</option>
                    <option name="origin_illness_innate">Врожденное</option>
                    <option name="origin_illness_obtained">Приобретенное</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Длительность болезни: </span>
            <div class="dropdown">
                <select size="1"  name="duration_illness" value="${duration_illness}">
                    <option name="no_info_about_changes">Нет сведений об изменениях</option>
                    <option name="changes_in_clinical_picture">Изменение клинического очага картины</option>
                    <option name="no_changes_during_3_month">Отсутствие изменений в течение 3-ех месяцев</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Изменение формы: </span>
            <div class="dropdown">
                <select size="1"  name="change_form" value="${change_form}">
                    <option name="change_form_none">Нет данных</option>
                    <option name="change_form_yes">Да</option>
                    <option name="change_form_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Изменение размера: </span>
            <div class="dropdown">
                <select size="1"  name="change_size" value="${change_size}">
                    <option name="change_size_none">Нет данных</option>
                    <option name="change_size_yes">Да</option>
                    <option name="change_size_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Изменение цвета: </span>
            <div class="dropdown">
                <select size="1"  name="change_color" value="${change_color}">
                    <option name="change_color_none">Нет данных</option>
                    <option name="change_color_yes">Да</option>
                    <option name="change_color_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Изменение чувствительности: </span>
            <div class="dropdown">
                <select size="1"  name="change_sensitivity" value="${change_sensitivity}">
                    <option name="change_sensitivity_none">Нет данных</option>
                    <option name="change_sensitivity_yes">Да</option>
                    <option name="change_sensitivity_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Наличие корок и кровоточивости: </span>
            <div class="dropdown">
                <select size="1"  name="crusts_and_bleeding" value="${crusts_and_bleeding}">
                    <option name="crusts_and_bleeding_none">Нет данных</option>
                    <option name="crusts_and_bleeding_yes">Да</option>
                    <option name="crusts_and_bleeding_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Болезненность опухоли: </span>
            <div class="dropdown">
                <select size="1"  name="tumor_pain" value="${tumor_pain}">
                    <option name="tumor_pain_none">Нет данных</option>
                    <option name="tumor_pain_yes">Да</option>
                    <option name="tumor_pain_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Сателлиты: </span>
            <div class="dropdown">
                <select size="1"  name="satellite" value="${satellite}">
                    <option name="satellite_none">Нет данных</option>
                    <option name="satellite_yes">Да</option>
                    <option name="satellite_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Наличие воспаления: </span>
            <div class="dropdown">
                <select size="1"  name="inflammations" value="${inflammations}">
                    <option name="inflammations_none">Нет данных</option>
                    <option name="inflammations_yes">Да</option>
                    <option name="inflammations_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Равномерная окраска: </span>
            <div class="dropdown">
                <select size="1"  name="uniform_coloring" value="${uniform_coloring}">
                    <option name="uniform_coloring_none">Нет данных</option>
                    <option name="uniform_coloring_yes">Да</option>
                    <option name="uniform_coloring_no">Нет</option>
                </select>
            </div>
        </div>

        <div class="block">                    
            <span>Тип кожи: </span>
            <div class="dropdown">
                <select size="1"  name="skin_type" value="${skin_type}">
                    <option name="skin_type_none">Нет данных</option>
                    <option name="skin_type_1">1</option>
                    <option name="skin_type_2">2</option>
                    <option name="skin_type_3">3</option>
                    <option name="skin_type_4">4</option>
                    <option name="skin_type_5">5</option>
                    <option name="skin_type_6">6</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Диаметр опухоли (мм): </span>
            <input type="number" name="tumor_diameter" value="${tumor_diameter}" min="1" required/>
        </div>

        <div class="block">
            <span>Форма опухоли: </span>
            <div class="dropdown">
                <select size="1"  name="tumor_form" value="${tumor_form}">
                    <option name="flat">Плоская</option>
                    <option name="tuberous">Бугристая</option>
                    <option name="nodular">Узловая</option>
                    <option name="hemispherical">Полусферическая</option>
                    <option name="mushroom_shaped">Грибовидная</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Поверхность опухоли: </span>
            <div class="dropdown">
                <select size="1"  name="tumor_surface" value="${tumor_surface}">
                    <option name="smooth">Гладкая</option>
                    <option name="tuberosity">Бугристая</option>
                    <option name="fine_grained">Мелкозернистая</option>
                    <option name="with_keratosis">С кератозом</option>
                    <option name="moist">Мокнущая</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Очертания опухоли: </span>
            <div class="dropdown">
                <select size="1"  name="tumor_outline" value="${tumor_outline}">
                    <option name="clear">Четкие</option>
                    <option name="fuzzy">Нечеткие</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Локализация опухоли: </span>
            <div class="dropdown">
                <select size="1"  name="tumor_localization" value="${tumor_localization}">
                    <option name="scalp">Волосистая часть головы</option>
                    <option name="face">Лицо</option>
                    <option name="organ_of_vision">Орган зрения</option>
                    <option name="oral_mucosa">Слизистая оболочка полости рта</option>
                    <option name="nasal_mucosa">Слизистая оболочка полости носа</option>
                    <option name="mucosa_of_the_paranasal_sinuses">Слизистая оболочка околоносовых пазух</option>
                    <option name="neck">Шея</option>
                    <option name="shoulder_girdle">Плечевой пояс</option>
                    <option name="axillary_region">Подмышечная область</option>
                    <option name="upper_extremity">Верхняя конечность</option>
                    <option name="palm">Ладони</option>
                    <option name="finger_nall_plate_of_the_upper_limb">Ногтевые пластинки пальцев верхней конечности</option>
                    <option name="anterior_thorax">Передняя поверхность грудной клетки</option>
                    <option name="back">Спина</option>
                    <option name="anterior_surface_of_the_abdominal_wall">Передняя поверхность брюшной стенки</option>
                    <option name="lumbar_region">Поясничная область</option>
                    <option name="groin">Паховая область</option>
                    <option name="vulva">Наружные половые органы</option>
                    <option name="gluteal_region">Ягодичная область</option>
                    <option name="perineum">Промежность</option>
                    <option name="lower_limb">Нижняя конечность</option>
                    <option name="thigh_area">Область бедра</option>
                    <option name="shin">Голень</option>
                    <option name="plantar_surface_of_the_foot">Подошвенная поверхность стопы</option>
                    <option name="finger_nail_plate_of_the_lower_limb">Ногтевые пластинки нижней конечности</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Устройство: </span>
            <div class="dropdown">
                <select size="1"  name="device" value="${device}">
                    <option name="dermatoscop">Дерматоскоп</option>
                    <option name="camera">Фотокамера</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Дата создания: </span>
            <input onclick="setMaxDate()" id="foto_date" type="date" name="date" min='1899-01-01' max='2000-01-01' placeholder="YYYY-MM-DD" data-date-split-input="true" value="${date}" required />
        </div>

        <div class="block">
            <span>Комментарий: </span>
            <textarea name="comments" ></textarea>
        </div>

        <div class="block">
            <div class="help">
                <div class="textHelp" id="help_1">Параметр RSA - <br>Пример: -0,2</div>
                <div class="imgHelp" onclick="toggleHelp(1)"></div>
            </div>
            <span>RSA: </span>
            <!--            <label for=""></label>-->
            <input type="text" name="rsa" value="${rsa}" pattern="([0]{1}){1}|((([0]{1}[.,]{1}){1}|([-]{1}[0]{1}[.,]{1}){1})(([0]{1}[0-9]{1}){1}|([1]{1}){1}){1}){1}" required/>
        </div>

        <div class="block">
            <span>Фотография: </span>
            <input type="file" name="file"/>
        </div>
        <input type="submit" name="createFotoForm" value="Добавить фото" onclick="add_foto()"/>
        <!--<input type="submit" name="createFotoForm" value="Добавить фото" onclick="echo('wow')"/>-->
        <!--<h3>${err}</h3>-->

    </form>
</div>
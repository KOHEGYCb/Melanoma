<%-- 
    Document   : CreateFotoForm
    Created on : Oct 24, 2018, 9:36:06 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="createFotoForm">
    <h3>Please, add foto and write information about this foto</h3>
    <form action="createFoto" method="Post">
        <div class="block">
            <span>Origin illness: </span>
            <div>
                <select size="1"  name="origin_illness" value="${origin_illness}">
                    <option name="innate">Innate</option>
                    <option name="obtained">Obtained</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Duration illness: </span>
            <div>
                <select size="1"  name="duration_illness" value="${duration_illness}">
                    <option name="no_info_about_changes">No info about changes</option>
                    <option name="changes_in_clinical_picture">Changes in clinical picture</option>
                    <option name="no_changes_during_3_month">No changes during 3 month</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Change form: </span>
            <div>
                <select size="1"  name="change_form" value="${change_form}">
                    <option name="change_form_none">Don't know</option>
                    <option name="change_form_yes">Yes</option>
                    <option name="change_form_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Change size: </span>
            <div>
                <select size="1"  name="change_size" value="${change_size}">
                    <option name="change_size_none">Don't know</option>
                    <option name="change_size_yes">Yes</option>
                    <option name="change_size_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>change_color: </span>
            <div>
                <select size="1"  name="change_color" value="${change_color}">
                    <option name="change_color_none">Don't know</option>
                    <option name="change_color_yes">Yes</option>
                    <option name="change_color_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>change_sensitivity: </span>
            <div>
                <select size="1"  name="change_sensitivity" value="${change_sensitivity}">
                    <option name="change_sensitivity_none">Don't know</option>
                    <option name="change_sensitivity_yes">Yes</option>
                    <option name="change_sensitivity_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>crusts_and_bleeding: </span>
            <div>
                <select size="1"  name="crusts_and_bleeding" value="${crusts_and_bleeding}">
                    <option name="crusts_and_bleeding_none">Don't know</option>
                    <option name="crusts_and_bleeding_yes">Yes</option>
                    <option name="crusts_and_bleeding_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>tumor_pain: </span>
            <div>
                <select size="1"  name="tumor_pain" value="${tumor_pain}">
                    <option name="tumor_pain_none">Don't know</option>
                    <option name="tumor_pain_yes">Yes</option>
                    <option name="tumor_pain_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>satellite: </span>
            <div>
                <select size="1"  name="satellite" value="${satellite}">
                    <option name="satellite_none">Don't know</option>
                    <option name="satellite_yes">Yes</option>
                    <option name="satellite_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>inflammations: </span>
            <div>
                <select size="1"  name="inflammations" value="${inflammations}">
                    <option name="inflammations_none">Don't know</option>
                    <option name="inflammations_yes">Yes</option>
                    <option name="inflammations_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>uniform_coloring: </span>
            <div>
                <select size="1"  name="uniform_coloring" value="${uniform_coloring}">
                    <option name="uniform_coloring_none">Don't know</option>
                    <option name="uniform_coloring_yes">Yes</option>
                    <option name="uniform_coloring_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">                    
            <span>skin type: </span>
            <div>
                <select size="1"  name="inflammations" value="${inflammations}">
                    <option name="inflammations_none">Don't know</option>
                    <option name="inflammations_yes">Yes</option>
                    <option name="inflammations_no">No</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>tumor_diameter (mm): </span>
            <input type="number" name="tumor_diameter" value="${tumor_diameter}" />
        </div>

        <div class="block">
            <span>Tumor form: </span>
            <div>
                <select size="1"  name="tumor_form" value="${tumor_form}">
                    <option name="flat">Flat</option>
                    <option name="tuberous">Tuberous</option>
                    <option name="nodular">Nodular</option>
                    <option name="hemispherical">Hemispherical</option>
                    <option name="mushroom_shaped">Mushroom shaped</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Tumor surface: </span>
            <div>
                <select size="1"  name="tumor_surface" value="${tumor_surface}">
                    <option name="smooth">Smooth</option>
                    <option name="tuberosity">Tuberosity</option>
                    <option name="fine_grained">Fine grained</option>
                    <option name="with_keratosis">With keratosis</option>
                    <option name="moist">Moist</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Tumor outline: </span>
            <div>
                <select size="1"  name="tumor_outline" value="${tumor_outline}">
                    <option name="clear">Clear</option>
                    <option name="fuzzy">Fuzzy</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Tumor localization: </span>
            <div>
                <select size="1"  name="tumor_localization" value="${tumor_localization}">
                    <option name="scalp">Scalp</option>
                    <option name="face">Face</option>
                    <option name="organ_of_vision">Organ of vision</option>
                    <option name="oral_mucosa">Oral mucosa</option>
                    <option name="nasal_mucosa">Nasal mucosa</option>
                    <option name="mucosa_of_the_paranasal_sinuses">Mucosa of the paranasal sinuses</option>
                    <option name="neck">Neck</option>
                    <option name="shoulder_girdle">Shoulder girdle</option>
                    <option name="axillary_region">Axillary region</option>
                    <option name="upper_extremity">Upper extremity</option>
                    <option name="palm">Palm</option>
                    <option name="finger_nall_plate_of_the_upper_limb">Finger nall plate of the upper limb</option>
                    <option name="anterior_thorax">Anterior thorax</option>
                    <option name="back">Back</option>
                    <option name="anterior_surface_of_the_abdominal_wall">Anterior surface of the abdominal wall</option>
                    <option name="lumbar_region">Lumbar region</option>
                    <option name="groin">Groin</option>
                    <option name="vulva">Vulva</option>
                    <option name="gluteal_region">Gluteal region</option>
                    <option name="perineum">Perineum</option>
                    <option name="lower_limb">Lower limb</option>
                    <option name="thigh_area">Thigh area</option>
                    <option name="shin">Shin</option>
                    <option name="plantar_surface_of_the_foot">Plantar surface of the foot</option>
                    <option name="finger_nail_plate_of_the_lower_limb">Finger nail plate of the lower limb</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>Device: </span>
            <div>
                <select size="1"  name="device" value="${device}">
                    <option name="dermatoscop">Dermatoscop</option>
                    <option name="camera">Camera</option>
                </select>
            </div>
        </div>

        <div class="block">
            <span>date: </span>
            <input type="date" name="date"    value="${date}"/>
        </div>

        <div class="block">
            <span>comments: </span>
            <textarea name="comments" ></textarea>
        </div>

        <br>
        <input type="submit" name="createFotoForm" value="Save info" />
    </form>
</div>
/* -----------------------------------------------------------------------------
 *  ________              __     __ _______         __
 * |  |  |  |.-----.----.|  |.--|  |   |   |.---.-.|  |--.-----.----.
 * |  |  |  ||  _  |   _||  ||  _  |       ||  _  ||    <|  -__|   _|
 * |________||_____|__|  |__||_____|__|_|__||___._||__|__|_____|__|
 *
 * Part of MiddleWar project.
 * -----------------------------------------------------------------------------
 * File    : business.BlockType.java
 *
 * History :
 * 1.0     : Add to wm, basic types
 *
 */

package middlewar.server.worldmaker.business;

import java.io.Serializable;
import middlewar.common.MiddlewarConfiguration;

/**
 * Every types of blocks
 * @author Higurashi
 * @version WM 1.0
 * @since WM 1.0
 */
public enum BlockType implements Serializable{

    // DIV /////////////////////////////////////////
    invisible("invisible"),
    ////////////////////////////////////////////////
    
    // DEV /////////////////////////////////////////
    dev_npc("dev/dev_npc"),
    dev_teleport("dev/dev_tele"),
    dev_uu("dev/dev_unusable"),
    dev_todo("dev/dev_todo"),
    dev_nice("dev/dev_nice"),
    dev_object("dev/dev_obj"),
    dev_unit("dev/dev_unit"),
    dev_unknown("dev/dev_unknown"),
    dev_unknown_up("dev/dev_unknown_up"),
    dev_unknown_down("dev/dev_unknown_down"),
    dev_unknown_up_down("dev/dev_unknown_up_down"),
    dev_notPassable("dev/dev_x"),
    dev_animation("dev/dev_anim"),
    dev_animation_1("dev/dev_anim_1"),
    dev_animation_2("dev/dev_anim_2"),
    dev_animation_3("dev/dev_anim_3"),
    ////////////////////////////////////////////////

    // ST / DESERT /////////////////////////////////
    desert_C("surfaces/desert/C"),
    ////////////////////////////////////////////////

    // INTERIOR 1///////////////////////////////////
    // B
    interior_1_C_E("surfaces/interior_1/B/C_E"),
    interior_1_C_I("surfaces/interior_1/B/C_I"),
    interior_1_N("surfaces/interior_1/B/N"),
    interior_1_E("surfaces/interior_1/B/E"),
    interior_1_S("surfaces/interior_1/B/S"),
    interior_1_O("surfaces/interior_1/B/O"),
    interior_1_NO("surfaces/interior_1/B/NO"),
    interior_1_NE("surfaces/interior_1/B/NE"),
    interior_1_SO("surfaces/interior_1/B/SO"),
    interior_1_SE("surfaces/interior_1/B/SE"),
    interior_1_NO_I("surfaces/interior_1/B/NO_I"),
    interior_1_NE_I("surfaces/interior_1/B/NE_I"),
    interior_1_SO_I("surfaces/interior_1/B/SO_I"),
    interior_1_SE_I("surfaces/interior_1/B/SE_I"),
    // E
    interior_1_N_M("surfaces/interior_1/E/N_M"),
    interior_1_E_M("surfaces/interior_1/E/E_M"),
    interior_1_O_M("surfaces/interior_1/E/O_M"),
    interior_1_S_M("surfaces/interior_1/E/S_M"),
    interior_1_V_M("surfaces/interior_1/E/V_M"),
    interior_1_H_M("surfaces/interior_1/E/H_M"),
    interior_1_C_M("surfaces/interior_1/E/C_M"),
    interior_1_HV_M("surfaces/interior_1/E/HV_M"),
    interior_1_NE_M("surfaces/interior_1/E/NE_M"),
    interior_1_SE_M("surfaces/interior_1/E/SE_M"),
    interior_1_NO_M("surfaces/interior_1/E/NO_M"),
    interior_1_SO_M("surfaces/interior_1/E/SO_M"),
    interior_1_NE_H_M("surfaces/interior_1/E/NE_H_M"),
    interior_1_SE_H_M("surfaces/interior_1/E/SE_H_M"),
    interior_1_NO_H_M("surfaces/interior_1/E/NO_H_M"),
    interior_1_SO_H_M("surfaces/interior_1/E/SO_H_M"),
    interior_1_NE_V_M("surfaces/interior_1/E/NE_V_M"),
    interior_1_SE_V_M("surfaces/interior_1/E/SE_V_M"),
    interior_1_NO_V_M("surfaces/interior_1/E/NO_V_M"),
    interior_1_SO_V_M("surfaces/interior_1/E/SO_V_M"),
    // L
    interior_1_SSO("surfaces/interior_1/L/SSO"),
    interior_1_SSE("surfaces/interior_1/L/SSE"),
    interior_1_SS("surfaces/interior_1/L/SS"),
    interior_1_S_D("surfaces/interior_1/L/S_D"),
    interior_1_SO_D("surfaces/interior_1/L/SO_D"),
    interior_1_SE_D("surfaces/interior_1/L/SE_D"),
    ////////////////////////////////////////////////


    // surface_default /////////////////////////////
    // B
    surface_default_C_E("surfaces/default/B/C_E"),
    surface_default_C_I("surfaces/default/B/C_I"),
    surface_default_N("surfaces/default/B/N"),
    surface_default_E("surfaces/default/B/E"),
    surface_default_S("surfaces/default/B/S"),
    surface_default_O("surfaces/default/B/O"),
    surface_default_NO("surfaces/default/B/NO"),
    surface_default_NE("surfaces/default/B/NE"),
    surface_default_SO("surfaces/default/B/SO"),
    surface_default_SE("surfaces/default/B/SE"),
    surface_default_NO_I("surfaces/default/B/NO_I"),
    surface_default_NE_I("surfaces/default/B/NE_I"),
    surface_default_SO_I("surfaces/default/B/SO_I"),
    surface_default_SE_I("surfaces/default/B/SE_I"),
    // E
    surface_default_N_M("surfaces/default/E/N_M"),
    surface_default_E_M("surfaces/default/E/E_M"),
    surface_default_O_M("surfaces/default/E/O_M"),
    surface_default_S_M("surfaces/default/E/S_M"),
    surface_default_V_M("surfaces/default/E/V_M"),
    surface_default_H_M("surfaces/default/E/H_M"),
    surface_default_C_M("surfaces/default/E/C_M"),
    surface_default_HV_M("surfaces/default/E/HV_M"),
    surface_default_NE_M("surfaces/default/E/NE_M"),
    surface_default_SE_M("surfaces/default/E/SE_M"),
    surface_default_NO_M("surfaces/default/E/NO_M"),
    surface_default_SO_M("surfaces/default/E/SO_M"),
    surface_default_NE_H_M("surfaces/default/E/NE_H_M"),
    surface_default_SE_H_M("surfaces/default/E/SE_H_M"),
    surface_default_NO_H_M("surfaces/default/E/NO_H_M"),
    surface_default_SO_H_M("surfaces/default/E/SO_H_M"),
    surface_default_NE_V_M("surfaces/default/E/NE_V_M"),
    surface_default_SE_V_M("surfaces/default/E/SE_V_M"),
    surface_default_NO_V_M("surfaces/default/E/NO_V_M"),
    surface_default_SO_V_M("surfaces/default/E/SO_V_M"),
    surface_default_O_V_M("surfaces/default/E/O_V_M"),
    surface_default_E_V_M("surfaces/default/E/E_V_M"),
    surface_default_S_H_M("surfaces/default/E/S_H_M"),
    surface_default_N_H_M("surfaces/default/E/N_H_M"),
    // L
    surface_default_SSO("surfaces/default/L/SSO"),
    surface_default_SSE("surfaces/default/L/SSE"),
    surface_default_SS("surfaces/default/L/SS"),
    surface_default_S_D("surfaces/default/L/S_D"),
    surface_default_SO_D("surfaces/default/L/SO_D"),
    surface_default_SE_D("surfaces/default/L/SE_D"),
    surface_default_N_U("surfaces/default/L/N_U"),
    surface_default_E_U("surfaces/default/L/E_U"),
    surface_default_S_U("surfaces/default/L/S_U"),
    surface_default_O_U("surfaces/default/L/O_U"),
    surface_default_NO_U("surfaces/default/L/NO_U"),
    surface_default_NE_U("surfaces/default/L/NE_U"),
    surface_default_SO_U("surfaces/default/L/SO_U"),
    surface_default_SE_U("surfaces/default/L/SE_U"),
    surface_default_NO_I_U("surfaces/default/L/NO_I_U"),
    surface_default_NE_I_U("surfaces/default/L/NE_I_U"),
    surface_default_SO_I_U("surfaces/default/L/SO_I_U"),
    surface_default_SE_I_U("surfaces/default/L/SE_I_U"),
    surface_default_OO("surfaces/default/L/OO"),
    surface_default_ONO("surfaces/default/L/ONO"),
    surface_default_OSO("surfaces/default/L/OSO"),
    surface_default_EE("surfaces/default/L/EE"),
    surface_default_ENE("surfaces/default/L/ENE"),
    surface_default_ESE("surfaces/default/L/ESE"),
    ////////////////////////////////////////////////


    // HEAVEN///////////////////////////////////////
    heaven_1_C_I("surfaces/heaven_1/B/C_I"),
    heaven_1_N("surfaces/heaven_1/B/N"),
    heaven_1_E("surfaces/heaven_1/B/E"),
    heaven_1_S("surfaces/heaven_1/B/S"),
    heaven_1_O("surfaces/heaven_1/B/O"),
    heaven_1_NO("surfaces/heaven_1/B/NO"),
    heaven_1_NE("surfaces/heaven_1/B/NE"),
    heaven_1_SO("surfaces/heaven_1/B/SO"),
    heaven_1_SE("surfaces/heaven_1/B/SE"),
    heaven_1_NO_I("surfaces/heaven_1/B/NO_I"),
    heaven_1_NE_I("surfaces/heaven_1/B/NE_I"),
    heaven_1_SO_I("surfaces/heaven_1/B/SO_I"),
    heaven_1_SE_I("surfaces/heaven_1/B/SE_I"),
    ////////////////////////////////////////////////

    // TOWN 1///////////////////////////////////////
    // B
    town_ground_1_C_I("surfaces/town_ground_1/B/C_I"),
    town_ground_1_N("surfaces/town_ground_1/B/N"),
    town_ground_1_E("surfaces/town_ground_1/B/E"),
    town_ground_1_S("surfaces/town_ground_1/B/S"),
    town_ground_1_O("surfaces/town_ground_1/B/O"),
    town_ground_1_NO("surfaces/town_ground_1/B/NO"),
    town_ground_1_NE("surfaces/town_ground_1/B/NE"),
    town_ground_1_SO("surfaces/town_ground_1/B/SO"),
    town_ground_1_SE("surfaces/town_ground_1/B/SE"),
    town_ground_1_NO_I("surfaces/town_ground_1/B/NO_I"),
    town_ground_1_NE_I("surfaces/town_ground_1/B/NE_I"),
    town_ground_1_SO_I("surfaces/town_ground_1/B/SO_I"),
    town_ground_1_SE_I("surfaces/town_ground_1/B/SE_I"),
    // E
    town_ground_1_HV_M("surfaces/town_ground_1/E/HV_M"),
    town_ground_1_C_M("surfaces/town_ground_1/E/C_M"),
    ////////////////////////////////////////////////

    // TOWN 2///////////////////////////////////////
    town_ground_2_C("surfaces/town_ground_2/C"),
    town_ground_2_N("surfaces/town_ground_2/N_all"),
    town_ground_2_E("surfaces/town_ground_2/E_all"),
    town_ground_2_S("surfaces/town_ground_2/S_all"),
    town_ground_2_O("surfaces/town_ground_2/O_all"),
    town_ground_2_NO("surfaces/town_ground_2/NO_all"),
    town_ground_2_NE("surfaces/town_ground_2/NE_all"),
    town_ground_2_SO("surfaces/town_ground_2/SO_all"),
    town_ground_2_SE("surfaces/town_ground_2/SE_all"),
    ////////////////////////////////////////////////

    // TOWN 3///////////////////////////////////////
    town_ground_3_C("surfaces/town_ground_3/C"),
    town_ground_3_N("surfaces/town_ground_3/N_all"),
    town_ground_3_E("surfaces/town_ground_3/E_all"),
    town_ground_3_S("surfaces/town_ground_3/S_all"),
    town_ground_3_O("surfaces/town_ground_3/O_all"),
    town_ground_3_NO("surfaces/town_ground_3/NO_all"),
    town_ground_3_NE("surfaces/town_ground_3/NE_all"),
    town_ground_3_SO("surfaces/town_ground_3/SO_all"),
    town_ground_3_SE("surfaces/town_ground_3/SE_all"),
    ////////////////////////////////////////////////

    // TOWN 4///////////////////////////////////////
    // B
    town_ground_4_C_I("surfaces/town_ground_4/B/C_I"),
    town_ground_4_N("surfaces/town_ground_4/B/N"),
    town_ground_4_E("surfaces/town_ground_4/B/E"),
    town_ground_4_S("surfaces/town_ground_4/B/S"),
    town_ground_4_O("surfaces/town_ground_4/B/O"),
    town_ground_4_NO("surfaces/town_ground_4/B/NO"),
    town_ground_4_NE("surfaces/town_ground_4/B/NE"),
    town_ground_4_SO("surfaces/town_ground_4/B/SO"),
    town_ground_4_SE("surfaces/town_ground_4/B/SE"),
    town_ground_4_NO_I("surfaces/town_ground_4/B/NO_I"),
    town_ground_4_NE_I("surfaces/town_ground_4/B/NE_I"),
    town_ground_4_SO_I("surfaces/town_ground_4/B/SO_I"),
    town_ground_4_SE_I("surfaces/town_ground_4/B/SE_I"),
    // E
    town_ground_4_N_M("surfaces/town_ground_4/E/N_M"),
    town_ground_4_E_M("surfaces/town_ground_4/E/E_M"),
    town_ground_4_O_M("surfaces/town_ground_4/E/O_M"),
    town_ground_4_S_M("surfaces/town_ground_4/E/S_M"),
    town_ground_4_V_M("surfaces/town_ground_4/E/V_M"),
    town_ground_4_H_M("surfaces/town_ground_4/E/H_M"),
    town_ground_4_C_M("surfaces/town_ground_4/E/C_M"),
    town_ground_4_HV_M("surfaces/town_ground_4/E/HV_M"),
    ////////////////////////////////////////////////

    // ST / GRASS_COAST ////////////////////////////
    grass_coast_mini("surfaces/grass_coast/C_all"),
    grass_coast_cross("surfaces/grass_coast/CROSS_all"),
    grass_coast_N("surfaces/grass_coast/N_all"),
    grass_coast_S("surfaces/grass_coast/S_all"),
    grass_coast_E("surfaces/grass_coast/E_all"),
    grass_coast_O("surfaces/grass_coast/O_all"),
    grass_coast_NO("surfaces/grass_coast/NO_all"),
    grass_coast_NE("surfaces/grass_coast/NE_all"),
    grass_coast_SO("surfaces/grass_coast/SO_all"),
    grass_coast_SE("surfaces/grass_coast/SE_all"),
    grass_coast_NO_I("surfaces/grass_coast/NO_I_all"),
    grass_coast_NE_I("surfaces/grass_coast/NE_I_all"),
    grass_coast_SO_I("surfaces/grass_coast/SO_I_all"),
    grass_coast_SE_I("surfaces/grass_coast/SE_I_all"),
    ////////////////////////////////////////////////

    // ST / GRASS_COAST 2 //////////////////////////
    grass_coast_2_mini("surfaces/grass_coast_2/C_all"),
    grass_coast_2_cross("surfaces/grass_coast_2/CROSS_all"),
    grass_coast_2_N("surfaces/grass_coast_2/N_all"),
    grass_coast_2_S("surfaces/grass_coast_2/S_all"),
    grass_coast_2_E("surfaces/grass_coast_2/E_all"),
    grass_coast_2_O("surfaces/grass_coast_2/O_all"),
    grass_coast_2_NO("surfaces/grass_coast_2/NO_all"),
    grass_coast_2_NE("surfaces/grass_coast_2/NE_all"),
    grass_coast_2_SO("surfaces/grass_coast_2/SO_all"),
    grass_coast_2_SE("surfaces/grass_coast_2/SE_all"),
    grass_coast_2_NO_I("surfaces/grass_coast_2/NO_I_all"),
    grass_coast_2_NE_I("surfaces/grass_coast_2/NE_I_all"),
    grass_coast_2_SO_I("surfaces/grass_coast_2/SO_I_all"),
    grass_coast_2_SE_I("surfaces/grass_coast_2/SE_I_all"),
    ////////////////////////////////////////////////

    /////// GRASS //////////////////////////////////
    // B
    grass_C_I("surfaces/grass_1/B/C_I"),
    grass_N("surfaces/grass_1/B/N"),
    grass_S("surfaces/grass_1/B/S"),
    grass_E("surfaces/grass_1/B/E"),
    grass_O("surfaces/grass_1/B/O"),
    grass_NO("surfaces/grass_1/B/NO"),
    grass_NE("surfaces/grass_1/B/NE"),
    grass_SO("surfaces/grass_1/B/SO"),
    grass_SE("surfaces/grass_1/B/SE"),
    grass_NO_I("surfaces/grass_1/B/NO_I"),
    grass_NE_I("surfaces/grass_1/B/NE_I"),
    grass_SO_I("surfaces/grass_1/B/SO_I"),
    grass_SE_I("surfaces/grass_1/B/SE_I"),
    // E
    grass_C_M("surfaces/grass_1/E/C_M"),
    grass_HV_M("surfaces/grass_1/E/HV_M"),
    // L
    grass_SO_D("surfaces/grass_1/L/SO_D"),
    grass_SE_D("surfaces/grass_1/L/SE_D"),
    grass_S_D("surfaces/grass_1/L/S_D"),
    grass_N_U("surfaces/grass_1/L/N_U"),
    grass_S_U("surfaces/grass_1/L/S_U"),
    grass_E_U("surfaces/grass_1/L/E_U"),
    grass_O_U("surfaces/grass_1/L/O_U"),
    grass_NO_U("surfaces/grass_1/L/NO_U"),
    grass_NE_U("surfaces/grass_1/L/NE_U"),
    grass_SO_U("surfaces/grass_1/L/SO_U"),
    grass_SE_U("surfaces/grass_1/L/SE_U"),
    grass_NO_I_U("surfaces/grass_1/L/NO_I_U"),
    grass_NE_I_U("surfaces/grass_1/L/NE_I_U"),
    grass_SO_I_U("surfaces/grass_1/L/SO_I_U"),
    grass_SE_I_U("surfaces/grass_1/L/SE_I_U"),
    grass_SSO("surfaces/grass_1/L/SSO"),
    grass_SSE("surfaces/grass_1/L/SSE"),
    grass_SS("surfaces/grass_1/L/SS"),

    /////// GRASS2 /////////////////////////////////
    grass_2_N("surfaces/grass_2/B/N"),
    grass_2_S("surfaces/grass_2/B/S"),
    grass_2_E("surfaces/grass_2/B/E"),
    grass_2_O("surfaces/grass_2/B/O"),
    grass_2_NO("surfaces/grass_2/B/NO"),
    grass_2_NE("surfaces/grass_2/B/NE"),
    grass_2_SO("surfaces/grass_2/B/SO"),
    grass_2_SE("surfaces/grass_2/B/SE"),
    // E
    grass_2_C_M("surfaces/grass_1/E/C_M"),
    // L
    grass_2_SO_D("surfaces/grass_1/L/SO_D"),
    grass_2_SE_D("surfaces/grass_1/L/SE_D"),
    grass_2_S_D("surfaces/grass_1/L/S_D"),
    ////////////////////////////////////////////////

    /////// GRASS3 /////////////////////////////////
    // L
    grass_3_SO_D("surfaces/grass_3/L/SO_D"),
    grass_3_SE_D("surfaces/grass_3/L/SE_D"),
    grass_3_S_D("surfaces/grass_3/L/S_D"),
    ////////////////////////////////////////////////

    /////// GRASS4 /////////////////////////////////
    // B
    grass_4_C_I("surfaces/grass_4/B/C_I"),
    grass_4_N("surfaces/grass_4/B/N"),
    grass_4_S("surfaces/grass_4/B/S"),
    grass_4_E("surfaces/grass_4/B/E"),
    grass_4_O("surfaces/grass_4/B/O"),
    grass_4_NO("surfaces/grass_4/B/NO"),
    grass_4_NE("surfaces/grass_4/B/NE"),
    grass_4_SO("surfaces/grass_4/B/SO"),
    grass_4_SE("surfaces/grass_4/B/SE"),
    grass_4_NO_I("surfaces/grass_4/B/NO_I"),
    grass_4_NE_I("surfaces/grass_4/B/NE_I"),
    grass_4_SO_I("surfaces/grass_4/B/SO_I"),
    grass_4_SE_I("surfaces/grass_4/B/SE_I"),
    // E
    grass_4_N_M("surfaces/grass_4/E/N_M"),
    grass_4_E_M("surfaces/grass_4/E/E_M"),
    grass_4_O_M("surfaces/grass_4/E/O_M"),
    grass_4_S_M("surfaces/grass_4/E/S_M"),
    grass_4_V_M("surfaces/grass_4/E/V_M"),
    grass_4_H_M("surfaces/grass_4/E/H_M"),
    grass_4_C_M("surfaces/grass_4/E/C_M"),
    grass_4_HV_M("surfaces/grass_4/E/HV_M"),
    ////////////////////////////////////////////////


    /////// GROUND1 ////////////////////////////////
    // B
    ground_1_C_I("surfaces/ground_1/B/C_I"),
    ground_1_N("surfaces/ground_1/B/N"),
    ground_1_S("surfaces/ground_1/B/S"),
    ground_1_E("surfaces/ground_1/B/E"),
    ground_1_O("surfaces/ground_1/B/O"),
    ground_1_NO("surfaces/ground_1/B/NO"),
    ground_1_NE("surfaces/ground_1/B/NE"),
    ground_1_SO("surfaces/ground_1/B/SO"),
    ground_1_SE("surfaces/ground_1/B/SE"),
    ground_1_NO_I("surfaces/ground_1/B/NO_I"),
    ground_1_NE_I("surfaces/ground_1/B/NE_I"),
    ground_1_SO_I("surfaces/ground_1/B/SO_I"),
    ground_1_SE_I("surfaces/ground_1/B/SE_I"),
    // E
    ground_1_C_M("surfaces/ground_1/E/C_M"),
    ground_1_HV_M("surfaces/ground_1/E/HV_M"),
    ////////////////////////////////////////////////

    /////// WATER1 /////////////////////////////////
    // B
    water_1_A_C_I("surfaces/water_1_A/B/C_I"),
    water_1_A_N("surfaces/water_1_A/B/N"),
    water_1_A_S("surfaces/water_1_A/B/S"),
    water_1_A_E("surfaces/water_1_A/B/E"),
    water_1_A_O("surfaces/water_1_A/B/O"),
    water_1_A_NO("surfaces/water_1_A/B/NO"),
    water_1_A_NE("surfaces/water_1_A/B/NE"),
    water_1_A_SO("surfaces/water_1_A/B/SO"),
    water_1_A_SE("surfaces/water_1_A/B/SE"),
    water_1_A_NO_I("surfaces/water_1_A/B/NO_I"),
    water_1_A_NE_I("surfaces/water_1_A/B/NE_I"),
    water_1_A_SO_I("surfaces/water_1_A/B/SO_I"),
    water_1_A_SE_I("surfaces/water_1_A/B/SE_I"),
    // E
    water_1_A_C_M("surfaces/water_1_A/E/C_M"),
    water_1_A_HV_M("surfaces/water_1_A/E/HV_M"),
    ////////////////////////////////////////////////

    /////// DEAMON1 ////////////////////////////////
    // B
    deamon_1_C_I("surfaces/deamon_1/B/C_I"),
    deamon_1_C_E("surfaces/deamon_1/B/C_E"),
    // L
    deamon_1_N_U("surfaces/deamon_1/L/N_U"),
    deamon_1_S_U("surfaces/deamon_1/L/S_U"),
    deamon_1_E_U("surfaces/deamon_1/L/E_U"),
    deamon_1_O_U("surfaces/deamon_1/L/O_U"),
    deamon_1_NO_U("surfaces/deamon_1/L/NO_U"),
    deamon_1_NE_U("surfaces/deamon_1/L/NE_U"),
    deamon_1_SO_U("surfaces/deamon_1/L/SO_U"),
    deamon_1_SE_U("surfaces/deamon_1/L/SE_U"),
    deamon_1_NO_I_U("surfaces/deamon_1/L/NO_I_U"),
    deamon_1_NE_I_U("surfaces/deamon_1/L/NE_I_U"),
    deamon_1_SO_I_U("surfaces/deamon_1/L/SO_I_U"),
    deamon_1_SE_I_U("surfaces/deamon_1/L/SE_I_U"),
    deamon_1_SO_D("surfaces/deamon_1/L/SO_D"),
    deamon_1_SE_D("surfaces/deamon_1/L/SE_D"),
    deamon_1_S_D("surfaces/deamon_1/L/S_D"),
    deamon_1_SSO("surfaces/deamon_1/L/SSO"),
    deamon_1_SSE("surfaces/deamon_1/L/SSE"),
    deamon_1_SS("surfaces/deamon_1/L/SS"),
    deamon_1_OO("surfaces/deamon_1/L/OO"),
    deamon_1_ONO("surfaces/deamon_1/L/ONO"),
    deamon_1_OSO("surfaces/deamon_1/L/OSO"),
    deamon_1_EE("surfaces/deamon_1/L/EE"),
    deamon_1_ENE("surfaces/deamon_1/L/ENE"),
    deamon_1_ESE("surfaces/deamon_1/L/ESE"),
    ////////////////////////////////////////////////

    /////// DEAMON2 ////////////////////////////////
    // B
    deamon_2_C_I("surfaces/deamon_2/B/C_I"),
    deamon_2_C_E("surfaces/deamon_2/B/C_E"),
    deamon_2_E("surfaces/deamon_2/B/E"),
    deamon_2_O("surfaces/deamon_2/B/O"),
    deamon_2_NO("surfaces/deamon_2/B/NO"),
    deamon_2_NE("surfaces/deamon_2/B/NE"),
    deamon_2_SO("surfaces/deamon_2/B/SO"),
    deamon_2_SE("surfaces/deamon_2/B/SE"),
    // L
    deamon_2_N_U("surfaces/deamon_2/L/N_U"),
    deamon_2_S_U("surfaces/deamon_2/L/S_U"),
    deamon_2_E_U("surfaces/deamon_2/L/E_U"),
    deamon_2_O_U("surfaces/deamon_2/L/O_U"),
    deamon_2_NO_U("surfaces/deamon_2/L/NO_U"),
    deamon_2_NE_U("surfaces/deamon_2/L/NE_U"),
    deamon_2_SO_U("surfaces/deamon_2/L/SO_U"),
    deamon_2_SE_U("surfaces/deamon_2/L/SE_U"),
    deamon_2_NO_I_U("surfaces/deamon_2/L/NO_I_U"),
    deamon_2_NE_I_U("surfaces/deamon_2/L/NE_I_U"),
    deamon_2_SO_I_U("surfaces/deamon_2/L/SO_I_U"),
    deamon_2_SE_I_U("surfaces/deamon_2/L/SE_I_U"),
    deamon_2_SO_D("surfaces/deamon_2/L/SO_D"),
    deamon_2_SE_D("surfaces/deamon_2/L/SE_D"),
    deamon_2_S_D("surfaces/deamon_2/L/S_D"),
    deamon_2_SSO("surfaces/deamon_2/L/SSO"),
    deamon_2_SSE("surfaces/deamon_2/L/SSE"),
    deamon_2_SS("surfaces/deamon_2/L/SS"),
    ////////////////////////////////////////////////
    
    // ST / ROCK ///////////////////////////////////
    rock_C("surfaces/rock/C"),
    rock_N("surfaces/rock/N"),
    rock_S("surfaces/rock/S"),
    rock_E("surfaces/rock/E"),
    rock_O("surfaces/rock/O"),
    rock_NO("surfaces/rock/NO"),
    rock_NE("surfaces/rock/NE"),
    rock_SO("surfaces/rock/SO"),
    rock_SE("surfaces/rock/SE"),
    rock_SS("surfaces/rock/SS"),
    ////////////////////////////////////////////////

    // OBJECTS /////////////////////////////////////

    object_simple_1("elements/objects/object_simple_1"),

    object_6_N("elements/objects/object_6_N"),
    object_6_S("elements/objects/object_6_S"),
    object_5_N("elements/objects/object_5_N"),
    object_5_S("elements/objects/object_5_S"),
    object_4_N("elements/objects/object_4_N"),
    object_4_S("elements/objects/object_4_S"),
    object_3_SO("elements/objects/object_3_SO"),
    object_3_SE("elements/objects/object_3_SE"),
    object_3_SC("elements/objects/object_3_SC"),
    object_3_NO("elements/objects/object_3_NO"),
    object_3_NE("elements/objects/object_3_NE"),
    object_3_NC("elements/objects/object_3_NC"),
    object_3_CO("elements/objects/object_3_CO"),
    object_3_CE("elements/objects/object_3_CE"),
    object_3_C("elements/objects/object_3_C"),
    object_3_BSO("elements/objects/object_3_BSO"),
    object_3_BSE("elements/objects/object_3_BSE"),
    object_3_BSC("elements/objects/object_3_BSC"),
    object_3_BNO("elements/objects/object_3_BNO"),
    object_3_BNE("elements/objects/object_3_BNE"),
    object_3_BNC("elements/objects/object_3_BNC"),
    object_2_N("elements/objects/object_2_N"),
    object_2_S("elements/objects/object_2_S"),
    object_1_C("elements/objects/object_1_C"),
    ////////////////////////////////////////////////

    // NATURE //////////////////////////////////////

    nature_simple_1("elements/nature/nature_simple_1"),
    nature_simple_2("elements/nature/nature_simple_2"),
    nature_simple_3("elements/nature/nature_simple_3"),

    nature_1_00("elements/nature/nature_1_00"),
    nature_1_01("elements/nature/nature_1_01"),
    nature_1_02("elements/nature/nature_1_02"),
    nature_1_03("elements/nature/nature_1_03"),
    nature_1_04("elements/nature/nature_1_04"),
    nature_1_10("elements/nature/nature_1_10"),
    nature_1_11("elements/nature/nature_1_11"),
    nature_1_12("elements/nature/nature_1_12"),
    nature_1_13("elements/nature/nature_1_13"),
    nature_1_14("elements/nature/nature_1_14"),
    nature_1_20("elements/nature/nature_1_20"),
    nature_1_21("elements/nature/nature_1_21"),
    nature_1_22("elements/nature/nature_1_22"),
    nature_1_23("elements/nature/nature_1_23"),
    nature_1_24("elements/nature/nature_1_24"),
    nature_1_30("elements/nature/nature_1_30"),
    nature_1_31("elements/nature/nature_1_31"),
    nature_1_32("elements/nature/nature_1_32"),
    nature_1_33("elements/nature/nature_1_33"),
    nature_1_34("elements/nature/nature_1_34"),

    nature_2_00("elements/nature/nature_2_00"),
    nature_2_01("elements/nature/nature_2_01"),
    nature_2_02("elements/nature/nature_2_02"),
    nature_2_03("elements/nature/nature_2_03"),
    nature_2_04("elements/nature/nature_2_04"),
    nature_2_10("elements/nature/nature_2_10"),
    nature_2_11("elements/nature/nature_2_11"),
    nature_2_12("elements/nature/nature_2_12"),
    nature_2_13("elements/nature/nature_2_13"),
    nature_2_14("elements/nature/nature_2_14"),
    nature_2_20("elements/nature/nature_2_20"),
    nature_2_21("elements/nature/nature_2_21"),
    nature_2_22("elements/nature/nature_2_22"),
    nature_2_23("elements/nature/nature_2_23"),
    nature_2_24("elements/nature/nature_2_24"),
    nature_2_30("elements/nature/nature_2_30"),
    nature_2_31("elements/nature/nature_2_31"),
    nature_2_32("elements/nature/nature_2_32"),
    nature_2_33("elements/nature/nature_2_33"),
    nature_2_34("elements/nature/nature_2_34"),

    nature_3_N("elements/nature/nature_3_N"),
    nature_3_S("elements/nature/nature_3_S"),
    ////////////////////////////////////////////////

    
    // STAIRS //////////////////////////////////////
    stairs_1_NE("elements/stairs/stairs_1_NE"),
    stairs_1_NO("elements/stairs/stairs_1_NO"),
    stairs_1_SE("elements/stairs/stairs_1_SE"),
    stairs_1_SO("elements/stairs/stairs_1_SO"),
    ////////////////////////////////////////////////

    // DOORS ///////////////////////////////////////
    door_1_NE("elements/doors/door_1_NE"),
    door_1_NO("elements/doors/door_1_NO"),
    door_1_SE("elements/doors/door_1_SE"),
    door_1_SO("elements/doors/door_1_SO"),
    door_1_S("elements/doors/door_1_S"),
    door_1_N("elements/doors/door_1_N"),
    ////////////////////////////////////////////////

    // ANIMATIONS / OBJ ////////////////////////////
    animation_object_1_f1("animations/objects/object_1_1"),
    animation_object_1_f2("animations/objects/object_1_2"),
    animation_object_1_f3("animations/objects/object_1_3"),
    animation_object_1_f4("animations/objects/object_1_4"),
    ////////////////////////////////////////////////

    // ANIMATIONS / EFF ////////////////////////////
    animation_effect_1_f1("animations/effects/effect_1_1"),
    animation_effect_1_f2("animations/effects/effect_1_2"),
    animation_effect_1_f3("animations/effects/effect_1_3"),
    animation_effect_1_f4("animations/effects/effect_1_4"),
    ////////////////////////////////////////////////

    // HOUSE1 //////////////////////////////////////
    house_1_face_00("elements/houses/house_1/F_00"),
    house_1_face_01("elements/houses/house_1/F_01"),
    house_1_face_02("elements/houses/house_1/F_02"),
    house_1_face_10("elements/houses/house_1/F_10"),
    house_1_face_11("elements/houses/house_1/F_11"),
    house_1_face_12("elements/houses/house_1/F_12"),
    house_1_face_20("elements/houses/house_1/F_20"),
    house_1_face_21("elements/houses/house_1/F_21"),
    house_1_face_22("elements/houses/house_1/F_22"),
    house_1_face_30("elements/houses/house_1/F_30"),
    house_1_face_31("elements/houses/house_1/F_31"),
    house_1_face_32("elements/houses/house_1/F_32"),

    house_1_roof_44("elements/houses/house_1/R_44"),
    house_1_roof_43("elements/houses/house_1/R_43"),
    house_1_roof_42("elements/houses/house_1/R_42"),
    house_1_roof_41("elements/houses/house_1/R_41"),
    house_1_roof_40("elements/houses/house_1/R_40"),
    house_1_roof_34("elements/houses/house_1/R_34"),
    house_1_roof_33("elements/houses/house_1/R_33"),
    house_1_roof_32("elements/houses/house_1/R_32"),
    house_1_roof_31("elements/houses/house_1/R_31"),
    house_1_roof_30("elements/houses/house_1/R_30"),
    house_1_roof_24("elements/houses/house_1/R_24"),
    house_1_roof_23("elements/houses/house_1/R_23"),
    house_1_roof_22("elements/houses/house_1/R_22"),
    house_1_roof_21("elements/houses/house_1/R_21"),
    house_1_roof_20("elements/houses/house_1/R_20"),
    house_1_roof_14("elements/houses/house_1/R_14"),
    house_1_roof_13("elements/houses/house_1/R_13"),
    house_1_roof_12("elements/houses/house_1/R_12"),
    house_1_roof_11("elements/houses/house_1/R_11"),
    house_1_roof_10("elements/houses/house_1/R_10"),
    house_1_roof_04("elements/houses/house_1/R_04"),
    house_1_roof_03("elements/houses/house_1/R_03"),
    house_1_roof_02("elements/houses/house_1/R_02"),
    house_1_roof_01("elements/houses/house_1/R_01"),
    house_1_roof_00("elements/houses/house_1/R_00");
    ////////////////////////////////////////////////

    // Location of the images
    public static final String IMAGE_PATH=MiddlewarConfiguration.getImageDistPath()+"blocks/";
    
    private String name;

    private BlockType(String name) {
        this.name = name;
    }

    /**
     * Return the image of the type
     * @return the image
     */
    public String getFullPathImage() {
        return IMAGE_PATH+this.name+".png";
    }

    public String getShortPathImage() {
        return this.name+".png";
    }

}

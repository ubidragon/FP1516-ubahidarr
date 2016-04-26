package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface Tutoria extends Comparable<Tutoria> {

	DayOfWeek getDiaSemana();

	LocalTime getHoraComienzo();

	LocalTime getHoraFin();

	Integer getDuracion();

}

/*
 * System.out.println(
 * "	                                    $,  $,     ,             ");
 * System.out.println(
 * "     Powered                            ss.$ss. .s'      ");
 * System.out.println(
 * "                                ,     .ss$$$$$$$$$$s,               ");
 * System.out.println(
 * "              by                $. s$$$$$$$$$$$$$$`$$Ss        ");
 * System.out.println(
 * "                                 $$$$$$$$$$$$$$$$$$o$$$       ,        ");
 * System.out.println(
 * "                               s$$$$$$$$$$$$$$$$$$$$$$$$s,  ,s   ");
 * System.out.println(
 * "                              s$$$$$$$$$'$$$$$$''''$$$$$$'$$$$$,      ");
 * System.out.println(
 * "                              s$$$$$$$$$$s''$$$$ssssss'$$$$$$$$'    ");
 * System.out.println(
 * "                             s$$$$$$$$$$'         `'''ss'$'$s''       ");
 * System.out.println(
 * "                             s$$$$$$$$$$,              `''''$  .s$$s ");
 * System.out.println(
 * "                             s$$$$$$$$$$$$s,...               `s$$'  ` ");
 * System.out.println(
 * "                         `ssss$$$$$$$$$$$$$$$$$$$$####s.     .$$'$.   , s- "
 * ); System.out.println(
 * "                           `''''$$$$$$$$$$$$$$$$$$$$#####$$$$$$'     $.$' "
 * ); System.out.println(
 * "                                 '$$$$$$$$$$$$$$$$$$$$$####s'''     .$$$| "
 * ); System.out.println(
 * "                                  '$$$$$$$$$$$$$$$$$$$$$$$$##s    .$$' $  "
 * ); System.out.println(
 * "                                   $$''$$$$$$$$$$$$$$$$$$$$$$$$$$$$$'   ` "
 * ); System.out.println(
 * "                                  $$'  '$'$$$$$$$$$$$$$$$$$$$$S'''''  ");
 * System.out.println(
 * "                             ,   ,'     '  $$$$$$$$$$$$$$$$####s   ");
 * System.out.println(
 * "                             $.          .s$$$$$$$$$$$$$$$$$####' ");
 * System.out.println(
 * "                 ,           '$s.   ..ssS$$$$$$$$$$$$$$$$$$$####' ");
 * System.out.println(
 * "                 $           .$$$S$$$$$$$$$$$$$$$$$$$$$$$$#####' ");
 * System.out.println(
 * "                 Ss     ..sS$$$$$$$$$$$$$$$$$$$$$$$$$$$######'' ");
 * System.out.println(
 * "                  '$$sS$$$$$$$$$$$$$$$$$$$$$$$$$$$########' ");
 * System.out.println("           ,      s$$$$$$$$$$$$$$$$$$$$$$$$#########''' "
 * ); System.out.println(
 * "           $    s$$$$$$$$$$$$$$$$$$$$$#######'''      s'         , ");
 * System.out.println(
 * "           $$..$$$$$$$$$$$$$$$$$$######''       ....,$$....    ,$ ");
 * System.out.println(
 * "            '$$$$$$$$$$$$$$$######'' ,     .sS$$$$$$$$$$$$$$$$s$$ ");
 * System.out.println(
 * "              $$$$$$$$$$$$#####'     $, .s$$$$$$$$$$$$$$$$$$$$$$$$s. ");
 * System.out.println(
 * "   )          $$$$$$$$$$$#####'      `$$$$$$$$$###########$$$$$$$$$$$. ");
 * System.out.println(
 * "  ((          $$$$$$$$$$$#####       $$$$$$$$###'       '####$$$$$$$$$$  ");
 * System.out.println(
 * "  ) (         $$$$$$$$$$$$####.     $$$$$$###'             '###$$$$$$$$$   s' "
 * ); System.out.println(
 * " (   )        $$$$$$$$$$$$$####.   $$$$$###'                ####$$$$$$$$s$$' "
 * ); System.out.println(
 * " )  ( (       $$'$$$$$$$$$$$#####.$$$$$###'  Ubidragon     .###$$$$$$$$$$' "
 * ); System.out.println(
 * " (  )  )   _,$'   $$$$$$$$$$$$######.$$##'                .###$$$$$$$$$$ ");
 * System.out.println(
 * " ) (  ( ).         '$$$$$$$$$$$$$#######,,,.          ..####$$$$$$$$$$$' ");
 * System.out.println(
 * "(   )$ )  )        ,$$$$$$$$$$$$$$$$$$####################$$$$$$$$$$$'         "
 * ); System.out.println(
 * "(   ($$  ( )     _sS'  `'$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$S$$,        "
 * ); System.out.println(
 * " )  )$$$s ) )  .      .   `$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$''  `$$    "
 * ); System.out.println(
 * "  (   $$$Ss/  .$,    .$,,s$$$$$$##S$$$$$$$$$$$$$$$$$$$$$$$$S''        '  ");
 * System.out.println(
 * "    ))_$$$$$$$$$$$$$$$$$$$$$$$##'  $$        `$$.        `$$. ");
 * System.out.println(
 * "        `'S$$$$$$$$$$$$$$$$$#'      $          `$          `$ ");
 * System.out.println(
 * "            `''''''''''''''         '           '           '  ");
 * 
 * 
 */
package com.ardagok.busstopapp.util;

import lombok.experimental.UtilityClass;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public final class MapBoxUtils {

    public static List<Coordinate> decode(final String encodedPath, int precision) {

        int len = encodedPath.length();
        // OSRM uses precision=6, the default Polyline spec divides by 1E5, capping at precision=5
        double factor = Math.pow(10, precision);

        // For speed we preallocate to an upper bound on the final length, then
        // truncate the array before returning.

        final List<Coordinate> path = new ArrayList<>();

        int index = 0;
        int lat = 0;
        int lng = 0;

        while (index < len) {

            int result = 1;
            int shift = 0;
            int b;
            do {

                b = encodedPath.charAt(index++) - 63 - 1;
                result += b << shift;
                shift += 5;
            }

            while (b >= 0x1f);

            lat += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);
            result = 1;
            shift = 0;
            do {

                b = encodedPath.charAt(index++) - 63 - 1;
                result += b << shift;
                shift += 5;
            }

            while (b >= 0x1f);
            lng += (result & 1) != 0 ? ~(result >> 1) : (result >> 1);

            path.add(new Coordinate(lng / factor, lat / factor));

        }

        return path;

    }

    public static String encode(final List<Coordinate> path, int precision) {

        long lastLat = 0;
        long lastLng = 0;

        final StringBuffer result = new StringBuffer();

        // OSRM uses precision=6, the default Polyline spec divides by 1E5, capping at precision=5
        double factor = Math.pow(10, precision);

        for (final Coordinate point : path) {

            long lat = Math.round(point.getY() * factor);
            long lng = Math.round(point.getX() * factor);

            long dLat = lat - lastLat;
            long dLng = lng - lastLng;

            encode(dLat, result);
            encode(dLng, result);

            lastLat = lat;
            lastLng = lng;
        }
        return result.toString();
    }

    private static void encode(long variable, StringBuffer result) {
        variable = variable < 0 ? ~(variable << 1) : variable << 1;
        while (variable >= 0x20) {
            result.append(Character.toChars((int) ((0x20 | (variable & 0x1f)) + 63)));
            variable >>= 5;
        }

        result.append(Character.toChars((int) (variable + 63)));
    }
}

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.hipparchus.analysis.differentiation.Gradient;
import org.hipparchus.analysis.differentiation.GradientField;
import org.hipparchus.geometry.euclidean.threed.FieldRotation;
import org.hipparchus.geometry.euclidean.threed.FieldVector3D;
import org.hipparchus.geometry.euclidean.threed.Rotation;
import org.hipparchus.geometry.euclidean.threed.Vector3D;
import org.hipparchus.util.MathArrays;
import org.orekit.frames.LOFType;
import org.orekit.utils.PVCoordinates;

import java.lang.reflect.Array;

// THIS IS WORKING
//@QuarkusMain
//public class Test {
//    public static void main(String... args) {
//        Quarkus.run(MyApp.class, args);
//    }
//
//    public static class MyApp implements QuarkusApplication {
//
//        @Override
//        public int run(String... args) throws Exception {
//            // THIS DOES NOT WORK
//            GradientField field = GradientField.getField(2);
//            final FieldVector3D<Gradient> plusI = FieldVector3D.getPlusI(field);
//            final FieldVector3D<Gradient> plusJ = FieldVector3D.getPlusJ(field);
//            final FieldVector3D<Gradient> plusK = FieldVector3D.getPlusK(field);
//            var rotation = new FieldRotation<Gradient>(plusJ, plusI, plusJ, plusK);
//            System.out.println(rotation.getAngle().getClass());
//            PVCoordinates pvCoordinates = new PVCoordinates(plusI.toVector3D(), plusJ.toVector3D());
//            Rotation rot = LOFType.TNW.rotationFromInertial(pvCoordinates);
//            System.out.println(rot.getAngle());
//            Quarkus.waitForExit();
//            return 0;
//        }
//    }
//
//}


// THIS IS NOT WORKING
@Path("/test")
public class Test {
    @POST
    public void test() {
        GradientField field = GradientField.getField(2);
        final FieldVector3D<Gradient> plusI = FieldVector3D.getPlusI(field);
        final FieldVector3D<Gradient> plusJ = FieldVector3D.getPlusJ(field);
        final FieldVector3D<Gradient> plusK = FieldVector3D.getPlusK(field);
        var rotation = new FieldRotation<Gradient>(plusJ, plusI, plusJ, plusK);
        System.out.println(rotation.getAngle().getClass());
        PVCoordinates pvCoordinates = new PVCoordinates(plusI.toVector3D(), plusJ.toVector3D());
        Rotation rot = LOFType.TNW.rotationFromInertial(pvCoordinates);
        System.out.println(rot.getAngle());

    }
}
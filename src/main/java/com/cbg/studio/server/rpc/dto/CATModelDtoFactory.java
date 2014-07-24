/**
 * 
 */
package com.cbg.studio.server.rpc.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.data.geometry.Bone;
import com.cbg.studio.client.data.geometry.DisplayBoneGroupList;
import com.cbg.studio.client.data.geometry.Joint;
import com.cbg.studio.client.data.geometry.Material;
import com.cbg.studio.client.data.geometry.MorphData;
import com.cbg.studio.client.data.geometry.Motion;
import com.cbg.studio.client.data.geometry.RigidBody;
import com.cbg.studio.client.data.geometry.Triangle;
import com.cbg.studio.client.data.geometry.Vertex;
import com.cbg.studio.client.data.geometry.VertexMorph;
import com.cbg.studio.client.engine.util.math.Vector2f;
import com.cbg.studio.client.engine.util.math.Vector3f;
import com.cbg.studio.server.domain.CATModel;

/**
 * @author Xif
 * 
 */
@SuppressWarnings("all")
public class CATModelDtoFactory {
    public static CATModelDto createModelDto(CATModel m) {
        CATModelDto dto = new CATModelDto();

        dto.setMaterials(convertMaterials(m.getMaterials()));
        dto.setBones(convertBones(m.getBones()));

        List<Bone> bones = dto.getBones();
        HashMap<String, Bone> boneMap = new HashMap<String, Bone>();

        for (Bone b : bones) {
            boneMap.put(b.getName(), b);
        }

        dto.setPolygons(convertPolygons(boneMap, m.getPolygons()));
        dto.setMotions(convertMotions(boneMap, m.getMotions()));
        dto.setVertexMorphList(convertMorphs(m.getVertexMorphList()));
        dto.setDisplayBoneGroups(convertDisplayBoneGroups(boneMap,
                m.getDisplayBoneGroups()));
        dto.setToonTextureList(m.getToonTextureList());
        dto.setRigidBodyList(convertRigidBodies(boneMap, m.getRigidBodyList()));

        List<RigidBody> rigidBodies = dto.getRigidBodyList();
        HashMap<String, RigidBody> bodyMap = new HashMap<String, RigidBody>();

        for (RigidBody b : rigidBodies) {
            bodyMap.put(b.getName(), b);
        }

        dto.setJointList(convertJoints(bodyMap, m.getJointList()));

        return dto;
    }

    private static <U, T> List<U> convertList(Class<U> outputType,
            List<T> domainList) {
        List<U> list = new ArrayList<U>();

        for (T domain : domainList) {
            list.add((U) createDto(outputType.getClass(), domain));
        }

        return list;
    }

    private static <U, T> U createDto(Class<U> outputType, T domain) {

        if (domain instanceof com.cbg.studio.server.domain.geometry.Material) {
            return (U) createMaterial((com.cbg.studio.server.domain.geometry.Material) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Triangle) {
            return (U) createTriangle((com.cbg.studio.server.domain.geometry.Triangle) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Motion) {
            return (U) createMotion((com.cbg.studio.server.domain.geometry.Motion) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Bone) {
            return (U) createBone((com.cbg.studio.server.domain.geometry.Bone) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.VertexMorph) {
            return (U) createVertexMorph((com.cbg.studio.server.domain.geometry.VertexMorph) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.DisplayBoneGroupList) {
            return (U) createDisplayBoneGroupList((com.cbg.studio.server.domain.geometry.DisplayBoneGroupList) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.RigidBody) {
            return (U) createRigidBody((com.cbg.studio.server.domain.geometry.RigidBody) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Joint) {
            return (U) createJoint((com.cbg.studio.server.domain.geometry.Joint) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Vertex) {
            return (U) createVertex((com.cbg.studio.server.domain.geometry.Vertex) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.MorphData) {
            return (U) createMorphData((com.cbg.studio.server.domain.geometry.MorphData) domain);
        }

        return null;
    }

    public static Vector2f createVector2f(
            com.cbg.studio.server.domain.geometry.Vector2 domain) {
        Vector2f vector = new Vector2f(domain.toArray());

        return vector;
    }

    public static Vertex createVertex(
            com.cbg.studio.server.domain.geometry.Vertex domain) {
        Vertex v = new Vertex();

        v.setBone0Weight(domain.getBone0Weight());
        v.setPosition(createVector3f(domain.getPosition()));
        v.setNormal(createVector3f(domain.getNormal()));
        v.setUv(createVector2f(domain.getUv()));

        return v;
    }

    public static Triangle createTriangle(
            com.cbg.studio.server.domain.geometry.Triangle domain) {
        Triangle t = new Triangle();

        List<Vertex> list = convertList(Vertex.class, domain.getVerticies());

        t.setVerticies(list);

        return t;
    }

    public static Bone createBone(
            com.cbg.studio.server.domain.geometry.Bone domain) {
        Bone b = new Bone();

        b.setName(domain.getName());
        b.setType(domain.getType());
        b.setPosition(createVector3f(domain.getPosition()));

        return b;
    }

    public static Motion createMotion(
            com.cbg.studio.server.domain.geometry.Motion domain) {
        Motion m = new Motion();

        m.setLinks(domain.getLinks());
        m.setIteration(domain.getIteration());
        m.setMaxAngle(domain.getMaxAngle());

        return m;
    }

    public static VertexMorph createVertexMorph(
            com.cbg.studio.server.domain.geometry.VertexMorph domain) {
        VertexMorph m = new VertexMorph();

        m.setName(domain.getName());
        m.setType(domain.getType());

        List<MorphData> mData = convertList(MorphData.class, domain.getData());

        m.setData(mData);

        return m;
    }

    public static MorphData createMorphData(
            com.cbg.studio.server.domain.geometry.MorphData domain) {
        MorphData md = new MorphData();

        md.setIndex(domain.getIndex());
        md.setOffset(createVector3f(domain.getOffset()));

        return md;
    }

    public static DisplayBoneGroupList createDisplayBoneGroupList(
            com.cbg.studio.server.domain.geometry.DisplayBoneGroupList domain) {
        DisplayBoneGroupList l = new DisplayBoneGroupList();

        l.setKeys(domain.getKeys());

        return l;
    }

    public static RigidBody createRigidBody(
            com.cbg.studio.server.domain.geometry.RigidBody domain) {
        RigidBody b = new RigidBody();

        b.setName(domain.getName());
        b.setCollisionGroupId(domain.getCollisionGroupId());
        b.setCollisionMaskId(domain.getCollisionMaskId());
        b.setShape(domain.getShape());
        b.setSize(createVector3f(domain.getSize()));
        b.setPosition(createVector3f(domain.getPosition()));
        b.setRotation(createVector3f(domain.getRotation()));
        b.setMass(domain.getMass());
        b.setVelocityAtt(domain.getVelocityAtt());
        b.setRotationAtt(domain.getRotationAtt());
        b.setBounce(domain.getBounce());
        b.setFriction(domain.getFriction());
        b.setMode(domain.getMode());

        return b;
    }

    public static Joint createJoint(
            com.cbg.studio.server.domain.geometry.Joint domain) {
        Joint j = new Joint();

        j.setName(domain.getName());
        j.setLocation(createVector3f(domain.getLocation()));
        j.setRotation(createVector3f(domain.getRotation()));
        j.setMinLoc(createVector3f(domain.getMinLoc()));
        j.setMaxLoc(createVector3f(domain.getMaxLoc()));
        j.setMinRot(createVector3f(domain.getMinRot()));
        j.setMaxRot(createVector3f(domain.getMaxRot()));
        j.setSpringConst(createVector3f(domain.getSpringConst()));
        j.setSpringRotConst(createVector3f(domain.getSpringRotConst()));

        return j;
    }

    public static List<Material> convertMaterials(
            List<com.cbg.studio.server.domain.geometry.Material> domainList) {
        List<Material> list = (List<Material>) convertList(Material.class,
                domainList);

        return list;
    }

    public static Material createMaterial(
            com.cbg.studio.server.domain.geometry.Material domain) {
        Material m = new Material();

        m.setColor(createVector3f(domain.getColor()));
        m.setSpecLight(createVector3f(domain.getSpecLight()));
        m.setAmbientLight(createVector3f(domain.getAmbientLight()));
        m.setTexture(domain.getTexture());

        return m;
    }

    public static Vector3f createVector3f(
            com.cbg.studio.server.domain.geometry.Vector domain) {
        Vector3f vector = new Vector3f(domain.toArray());
        return vector;
    }

    public static List<Triangle> convertPolygons(HashMap<String, Bone> bones,
            List<com.cbg.studio.server.domain.geometry.Triangle> domainList) {
        List<Triangle> list = convertList(Triangle.class, domainList);

        for (int x = 0; x < list.size(); x++) {
            Triangle t = list.get(x);
            com.cbg.studio.server.domain.geometry.Triangle dt = domainList
                    .get(x);

            List<Vertex> pList = t.getVerticies();
            List<com.cbg.studio.server.domain.geometry.Vertex> dList = dt
                    .getVerticies();

            for (int i = 0; i < pList.size(); i++) {
                Vertex v = pList.get(i);
                com.cbg.studio.server.domain.geometry.Vertex vd = dList.get(i);

                v.setBone0(bones.get(vd.getBone0Name()));
                v.setBone1(bones.get(vd.getBone1Name()));
            }
        }

        return list;
    }

    public static List<Bone> convertBones(
            List<com.cbg.studio.server.domain.geometry.Bone> domainList) {
        List<Bone> list = convertList(Bone.class, domainList);

        HashMap<String, Bone> boneMap = new HashMap<String, Bone>();

        for (Bone b : list) {
            boneMap.put(b.getName(), b);
        }

        for (int x = 0; x < list.size(); x++) {
            Bone b = list.get(x);
            com.cbg.studio.server.domain.geometry.Bone bd = domainList.get(x);

            b.setParent(boneMap.get(bd.getParentName()));
            b.setChild(boneMap.get(bd.getChildName()));
            b.setTarget(boneMap.get(bd.getTargetName()));
        }

        return list;
    }

    public static List<Motion> convertMotions(HashMap<String, Bone> bones,
            List<com.cbg.studio.server.domain.geometry.Motion> domainList) {
        List<Motion> list = convertList(Motion.class, domainList);

        for (int x = 0; x < list.size(); x++) {
            Motion m = list.get(x);
            com.cbg.studio.server.domain.geometry.Motion md = domainList.get(x);

            m.setBone(bones.get(md.getBoneName()));
            m.setTargetBone(bones.get(md.getTargetBoneName()));

            List<Bone> cBones = new ArrayList<Bone>();
            for (String bd : md.getChildBoneNames()) {
                cBones.add(bones.get(bd));
            }

            m.setChildBones(cBones);
        }

        return list;
    }

    public static List<VertexMorph> convertMorphs(
            List<com.cbg.studio.server.domain.geometry.VertexMorph> domainList) {
        List<VertexMorph> list = convertList(VertexMorph.class, domainList);

        return list;
    }

    public static DisplayBoneGroupList convertDisplayBoneGroups(
            HashMap<String, Bone> bones,
            com.cbg.studio.server.domain.geometry.DisplayBoneGroupList domain) {
        DisplayBoneGroupList groupList = createDisplayBoneGroupList(domain);

        for (String key : groupList.getKeys()) {
            List<String> gList = domain.getGroup(key);

            List<Bone> groupBones = new ArrayList<Bone>();

            for (String bd : gList) {
                groupBones.add(bones.get(bd));
            }

            groupList.put(key, groupBones);
        }

        return groupList;
    }

    public static List<RigidBody> convertRigidBodies(
            HashMap<String, Bone> bones,
            List<com.cbg.studio.server.domain.geometry.RigidBody> domainList) {
        List<RigidBody> list = convertList(RigidBody.class, domainList);

        for (int x = 0; x < list.size(); x++) {
            RigidBody rb = list.get(x);
            com.cbg.studio.server.domain.geometry.RigidBody md = domainList
                    .get(x);

            rb.setBone(bones.get(md.getBoneName()));
        }

        return list;
    }

    public static List<Joint> convertJoints(HashMap<String, RigidBody> bodies,
            List<com.cbg.studio.server.domain.geometry.Joint> domainList) {
        List<Joint> list = convertList(Joint.class, domainList);

        for (int x = 0; x < list.size(); x++) {
            Joint j = list.get(x);
            com.cbg.studio.server.domain.geometry.Joint dj = domainList.get(x);

            j.setSourceRigidBody(bodies.get(dj.getSourceRigidBodyName()));
            j.setDestRigidBody(bodies.get(dj.getDestRigidBodyName()));
        }

        return list;
    }
}

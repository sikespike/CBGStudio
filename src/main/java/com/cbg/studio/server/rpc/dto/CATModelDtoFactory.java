/**
 * 
 */
package com.cbg.studio.server.rpc.dto;

import java.util.ArrayList;
import java.util.List;

import com.cbg.studio.client.data.CATModelDto;
import com.cbg.studio.client.data.geometry.Bone;
import com.cbg.studio.client.data.geometry.DisplayBoneGroupList;
import com.cbg.studio.client.data.geometry.Joint;
import com.cbg.studio.client.data.geometry.Material;
import com.cbg.studio.client.data.geometry.Motion;
import com.cbg.studio.client.data.geometry.RigidBody;
import com.cbg.studio.client.data.geometry.Triangle;
import com.cbg.studio.client.data.geometry.Vector;
import com.cbg.studio.client.data.geometry.Vector2;
import com.cbg.studio.client.data.geometry.Vertex;
import com.cbg.studio.client.data.geometry.VertexMorph;
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
        dto.setPolygons(convertPolygons(m.getPolygons()));
        dto.setBones(convertBones(m.getBones()));
        dto.setMotions(convertMotions(m.getMotions()));
        dto.setVertexMorphList(convertMorphs(m.getVertexMorphList()));
        dto.setDisplayBoneGroups(convertDisplayBoneGroups(m
                .getDisplayBoneGroups()));
        dto.setToonTextureList(m.getToonTextureList());
        dto.setRigidBodyList(convertRigidBodies(m.getRigidBodyList()));
        dto.setJointList(convertJoints(m.getJointList()));

        return dto;
    }

    private static <U, T> List<U> convertList(Class<U> outputType, List<T> domainList) {
        List<U> list = new ArrayList<U>();
        
        for (T domain : domainList) {
            list.add((U)createDto(outputType.getClass(), domain));
        }

        return list;
    }

    private static <U, T> U createDto(Class<U> outputType, T domain) {

        if (domain instanceof com.cbg.studio.server.domain.geometry.Material) {
            return (U)createMaterial((com.cbg.studio.server.domain.geometry.Material) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Triangle) {
            return (U)createTriangle((com.cbg.studio.server.domain.geometry.Triangle) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Bone) {
            return (U)createBone((com.cbg.studio.server.domain.geometry.Bone) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Motion) {
            return (U)createMotion((com.cbg.studio.server.domain.geometry.Motion) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.VertexMorph) {
            return (U)createVertexMorph((com.cbg.studio.server.domain.geometry.VertexMorph) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.DisplayBoneGroupList) {
            return (U)createDisplayBoneGroupList((com.cbg.studio.server.domain.geometry.DisplayBoneGroupList) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.RigidBody) {
            return (U)createRigidBody((com.cbg.studio.server.domain.geometry.RigidBody) domain);
        } else if (domain instanceof com.cbg.studio.server.domain.geometry.Joint) {
            return (U)createJoint((com.cbg.studio.server.domain.geometry.Joint) domain);
        } else if(domain instanceof com.cbg.studio.server.domain.geometry.Vertex){
            return (U)createVertex((com.cbg.studio.server.domain.geometry.Vertex)domain);
        }

        return null;
    }

    public static Vector2 createVector2(com.cbg.studio.server.domain.geometry.Vector2 domain){
        Vector2 vector = new Vector2(domain.toArray());
        
        return vector;
    }
    
    public static Vertex createVertex(com.cbg.studio.server.domain.geometry.Vertex domain){
        Vertex v = new Vertex();
        
        v.setBone0Name(domain.getBone0Name());
        v.setBone1Name(domain.getBone1Name());
        v.setBone0Weight(domain.getBone0Weight());
        v.setPosition(createVector(domain.getPosition()));
        v.setNormal(createVector(domain.getNormal()));
        v.setUv(createVector2(domain.getUv()));
        
        return v;
    }
    
    public static Triangle createTriangle(com.cbg.studio.server.domain.geometry.Triangle domain){
        Triangle t = new Triangle();
        
        List<Vertex> list = convertList(Vertex.class, domain.getVerticies());
        
        t.setVerticies(list);
        
        return t;
    }
    
    public static Bone createBone(com.cbg.studio.server.domain.geometry.Bone domain){
        Bone b = new Bone();
        
        return b;
    }
    public static Motion createMotion(com.cbg.studio.server.domain.geometry.Motion domain){
        Motion m = new Motion();
        
        return m;
    }
    public static VertexMorph createVertexMorph(com.cbg.studio.server.domain.geometry.VertexMorph domain){
        VertexMorph m = new VertexMorph();
        
        return m;
    }
    public static DisplayBoneGroupList createDisplayBoneGroupList(com.cbg.studio.server.domain.geometry.DisplayBoneGroupList domain){
        DisplayBoneGroupList l = new DisplayBoneGroupList();
        
        return l;
    }
    public static RigidBody createRigidBody(com.cbg.studio.server.domain.geometry.RigidBody domain){
        RigidBody b = new RigidBody();
        
        return b;
    }
    public static Joint createJoint(com.cbg.studio.server.domain.geometry.Joint domain){
        Joint j = new Joint();
        
        return j;
    }
    
    
    public static List<Material> convertMaterials(
            List<com.cbg.studio.server.domain.geometry.Material> domainList) {
        List<Material> list = (List<Material>)convertList(Material.class,domainList);

        return list;
    }

    public static Material createMaterial(
            com.cbg.studio.server.domain.geometry.Material domain) {
        Material m = new Material();

        m.setColor(createVector(domain.getColor()));
        m.setSpecLight(createVector(domain.getSpecLight()));
        m.setAmbientLight(createVector(domain.getAmbientLight()));
        m.setTexture(domain.getTexture());

        return m;
    }

    public static Vector createVector(
            com.cbg.studio.server.domain.geometry.Vector domain) {
        Vector vector = new Vector(domain.toArray());
        return vector;
    }

    public static List<Triangle> convertPolygons(
            List<com.cbg.studio.server.domain.geometry.Triangle> domainList) {
        List<Triangle> list = convertList(Triangle.class, domainList);

        return list;
    }

    public static List<Bone> convertBones(
            List<com.cbg.studio.server.domain.geometry.Bone> domainList) {
        List<Bone> list = convertList(Bone.class, domainList);

        return list;
    }

    public static List<Motion> convertMotions(
            List<com.cbg.studio.server.domain.geometry.Motion> domainList) {
        List<Motion> list = convertList(Motion.class, domainList);

        return list;
    }

    public static List<VertexMorph> convertMorphs(
            List<com.cbg.studio.server.domain.geometry.VertexMorph> domainList) {
        List<VertexMorph> list = convertList(VertexMorph.class, domainList);

        return list;
    }

    public static DisplayBoneGroupList convertDisplayBoneGroups(
            com.cbg.studio.server.domain.geometry.DisplayBoneGroupList domainObject) {
        DisplayBoneGroupList groupList = createDisplayBoneGroupList(domainObject);

        return groupList;
    }

    public static List<RigidBody> convertRigidBodies(
            List<com.cbg.studio.server.domain.geometry.RigidBody> domainList) {
        List<RigidBody> list = convertList(RigidBody.class, domainList);

        return list;
    }

    public static List<Joint> convertJoints(
            List<com.cbg.studio.server.domain.geometry.Joint> domainList) {
        List<Joint> list = convertList(Joint.class, domainList);

        return list;
    }
}

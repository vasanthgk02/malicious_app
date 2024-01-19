package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSDictionaryMap;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDNameTreeNode;
import org.apache.pdfbox.pdmodel.common.PDNumberTreeNode;

public class PDStructureTreeRoot extends PDStructureNode {
    public static final String TYPE = "StructTreeRoot";

    public PDStructureTreeRoot() {
        super((String) TYPE);
    }

    public PDNameTreeNode getIDTree() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.ID_TREE);
        if (cOSDictionary != null) {
            return new PDNameTreeNode(cOSDictionary, PDStructureElement.class);
        }
        return null;
    }

    public COSBase getK() {
        return getCOSDictionary().getDictionaryObject(COSName.K);
    }

    public COSArray getKArray() {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(COSName.K);
        if (dictionaryObject != null) {
            if (!(dictionaryObject instanceof COSDictionary)) {
                return (COSArray) dictionaryObject;
            }
            COSBase dictionaryObject2 = ((COSDictionary) dictionaryObject).getDictionaryObject(COSName.K);
            if (dictionaryObject2 instanceof COSArray) {
                return (COSArray) dictionaryObject2;
            }
        }
        return null;
    }

    public PDNumberTreeNode getParentTree() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSDictionary().getDictionaryObject(COSName.PARENT_TREE);
        if (cOSDictionary != null) {
            return new PDNumberTreeNode(cOSDictionary, COSBase.class);
        }
        return null;
    }

    public int getParentTreeNextKey() {
        return getCOSDictionary().getInt(COSName.PARENT_TREE_NEXT_KEY);
    }

    public Map<String, Object> getRoleMap() {
        COSBase dictionaryObject = getCOSDictionary().getDictionaryObject(COSName.ROLE_MAP);
        if (dictionaryObject instanceof COSDictionary) {
            try {
                return COSDictionaryMap.convertBasicTypesToMap((COSDictionary) dictionaryObject);
            } catch (IOException e2) {
                e2.getMessage();
            }
        }
        return new Hashtable();
    }

    public void setIDTree(PDNameTreeNode pDNameTreeNode) {
        getCOSDictionary().setItem(COSName.ID_TREE, (COSObjectable) pDNameTreeNode);
    }

    public void setK(COSBase cOSBase) {
        getCOSDictionary().setItem(COSName.K, cOSBase);
    }

    public void setParentTree(PDNumberTreeNode pDNumberTreeNode) {
        getCOSDictionary().setItem(COSName.PARENT_TREE, (COSObjectable) pDNumberTreeNode);
    }

    public void setParentTreeNextKey(int i) {
        getCOSDictionary().setInt(COSName.PARENT_TREE_NEXT_KEY, i);
    }

    public void setRoleMap(Map<String, String> map) {
        COSDictionary cOSDictionary = new COSDictionary();
        for (Entry next : map.entrySet()) {
            cOSDictionary.setName((String) next.getKey(), (String) next.getValue());
        }
        getCOSDictionary().setItem(COSName.ROLE_MAP, (COSBase) cOSDictionary);
    }

    public PDStructureTreeRoot(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
